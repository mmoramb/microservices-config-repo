import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MewCmpComponent } from './mew-cmp.component';

describe('MewCmpComponent', () => {
  let component: MewCmpComponent;
  let fixture: ComponentFixture<MewCmpComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MewCmpComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MewCmpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
