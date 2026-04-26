import { Component } from "@angular/core";
import { CommonModule } from "@angular/common";
import { FormsModule } from "@angular/forms";
import {
  IonButton,
  IonCard,
  IonCardContent,
  IonCardHeader,
  IonCardSubtitle,
  IonCardTitle,
  IonContent,
  IonHeader,
  IonInput,
  IonItem,
  IonLabel,
  IonList,
  IonListHeader,
  IonTitle,
  IonToolbar,
} from "@ionic/angular/standalone";


@Component({ selector:"app-home",
  templateUrl:"home.page.html", styleUrls:["home.page.scss"],
  standalone:true,
  imports:[CommonModule, FormsModule, IonHeader, IonToolbar, IonTitle,
    IonContent, IonItem, IonLabel, IonInput, IonButton, IonList,
    IonListHeader, IonCard, IonCardHeader, IonCardTitle, IonCardSubtitle,
    IonCardContent] })
export class HomePage {
  ingredients = "";
  recipes: any[] = [];
  noMatch = false;


  db = [
    { keys:["egg","tomato"], name:"Egg Tomato Scramble",
      nutrition:"Calories: 250 | Protein: 14g | Carbs: 8g",
      instructions:"1. Beat eggs. 2. Sauté tomato 2 min. 3. Add eggs, stir until cooked. Serve hot." },
    { keys:["rice","egg"], name:"Egg Fried Rice",
      nutrition:"Calories: 380 | Protein: 12g | Carbs: 55g",
      instructions:"1. Cook rice. 2. Fry egg. 3. Mix together with soy sauce and vegetables." },
    { keys:["pasta"], name:"Simple Pasta",
      nutrition:"Calories: 320 | Protein: 10g | Carbs: 60g",
      instructions:"1. Boil pasta 8-10 min. 2. Drain. 3. Toss with olive oil and seasoning." },
    { keys:["chicken","tomato"], name:"Chicken Tomato Curry",
      nutrition:"Calories: 450 | Protein: 35g | Carbs: 15g",
      instructions:"1. Sauté onion. 2. Add chicken, brown 5 min. 3. Add tomato+spices. Simmer 20 min." },
  ];


  findRecipes(){
    const ing = this.ingredients.toLowerCase().split(",").map(s=>s.trim());
    this.recipes = this.db.filter(r=>r.keys.some(k=>ing.includes(k)));
    this.noMatch = this.recipes.length === 0;
  }
}
