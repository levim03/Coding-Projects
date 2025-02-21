const image_input = document.querySelector("#image_input") //to take an image from user from form
var uploaded_image = "";


//start point of image slider
var i = 0;
var images= [];
var time = 3000;

//image list
images[0] = "Pictures2/Anakins Custom Jedi Starfighter 2.jpg";
images[1] = "Pictures2/Droid Gunship 2.jpg";
images[2] = "Pictures2/Homing Spider Droid 2.jpg";

//change the image
function changeImg(){

    var slide = document.getElementById("slide");
  slide.src = images[i];
  if (i < images.length - 1) {
    i++;
  } else {
    i = 0;
  }
  setTimeout(changeImg, time); 
}

window.onload = changeImg;

//Color changer
const paragraphI = document.getElementById('paragraph');  
const colors = ['black', 'white'];
let j = 0;

setInterval(function() {
  paragraphI.style.color = colors[j];
  j = (j + 1) % colors.length;
}, 3000);

