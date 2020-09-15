import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserInputsComponent } from './user-inputs/user-inputs.component';
import { ItemComponentComponent } from './item-component/item-component.component';
import { SelectorComponentComponent } from './selector-component/selector-component.component';



@NgModule({
  declarations: [UserInputsComponent, ItemComponentComponent, SelectorComponentComponent],
  imports: [
    CommonModule
  ]
})
export class PageComponentsModule { }
