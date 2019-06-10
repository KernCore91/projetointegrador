import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BemComponent } from './bem.component';

describe('BemComponent', () => {
	let component: BemComponent;
	let fixture: ComponentFixture<BemComponent>;

	beforeEach(async(() => {
		TestBed.configureTestingModule({
			declarations: [BemComponent]
		})
			.compileComponents();
	}));

	beforeEach(() => {
		fixture = TestBed.createComponent(BemComponent);
		component = fixture.componentInstance;
		fixture.detectChanges();
	});

	it('should create', () => {
		expect(component).toBeTruthy();
	});
});
