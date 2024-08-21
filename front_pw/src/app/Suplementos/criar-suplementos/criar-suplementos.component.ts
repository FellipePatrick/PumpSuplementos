import { Component } from '@angular/core';
import {takeUntilDestroyed} from '@angular/core/rxjs-interop';
import {FormControl, FormsModule, ReactiveFormsModule, Validators} from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {merge} from 'rxjs';

@Component({
  selector: 'app-criar-suplementos',
  standalone: true,
  imports: [MatFormFieldModule, MatInputModule, FormsModule, ReactiveFormsModule],
  templateUrl: './criar-suplementos.component.html',
  styleUrl: './criar-suplementos.component.scss'
})
export class CriarSuplementosComponent {
  Title:string = "To Do List Application";
  imageLink:string= "https://cdn-icons-png.flaticon.com/512/4697/4697260.png";

  tasks : string[] =[];
  newTask : string="";
  isAvalible : boolean = false;
  addTask()
  {
    if(this.newTask.trim() !=="")
    {
      this.tasks.push(this.newTask);
      this.newTask="";
      this.isAvalible = true;
    }

  }
  RemoveTask(index :number)
  {
    this.tasks.splice(index,1);
    this.isAvalible = this.tasks.length > 0;
  }
  // EditTask(index :number)
  // {
  //   let updateTask = prompt("Edit Task",this.tasks[index]);
  //   if(updateTask !==null)
  //   {
  //     this.tasks[index] = updateTask.trim();
  //   }
  // }
  EditTask(index:number, newtaskEdit:string) : string | void
  {
    const trimedTask = newtaskEdit.trim();
    if(newtaskEdit.trim() !== "")
    {
      this.tasks[index] = trimedTask;
    }
    else
    {
      newtaskEdit = this.tasks[index];
      return this.newTask = newtaskEdit;
    }
    this.newTask ="";
  }
}
