import {HttpErrorResponse, HttpInterceptorFn} from '@angular/common/http';
import {catchError, switchMap, throwError} from 'rxjs';
import {inject} from '@angular/core';
import {Auth} from '../../services/auth/auth';

export const authInterceptor: HttpInterceptorFn = (req, next) => {
  const authService = inject(Auth);
  const accessToken = authService.getAccessToken();

  if (req.url.includes('/auth/')) {
    return next(req);
  }

  const authReq = req.clone({
    setHeaders: {
      Authorization: `Bearer ${accessToken}`
    }
  });

  return next(authReq).pipe(
    catchError((error: HttpErrorResponse) => {
      if (error.status === 401) {
        const refreshToken = authService.getRefreshToken();
        if (!refreshToken || !authService.isRefreshTokenNonExpired()) {
          authService.logout();
          return throwError(() => error);
        }

        return authService.refreshToken(refreshToken).pipe(
          switchMap((tokens: any) => {
            localStorage.setItem('accessToken', tokens.accessToken);
            localStorage.setItem('refreshToken', tokens.refreshToken);

            const newReq = req.clone({
              setHeaders: {
                Authorization: `Bearer ${tokens.accessToken}`
              }
            });
            return next(newReq);
          })
        );
      }
      return throwError(() => error);
    })
  );
};
