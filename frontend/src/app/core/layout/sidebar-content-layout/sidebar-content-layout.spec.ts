import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SidebarContentLayout } from './sidebar-content-layout';

describe('SidebarContentLayout', () => {
  let component: SidebarContentLayout;
  let fixture: ComponentFixture<SidebarContentLayout>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SidebarContentLayout]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SidebarContentLayout);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
