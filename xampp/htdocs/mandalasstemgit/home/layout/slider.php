<link rel="stylesheet" href="static/css/layout/slider.css">

<div class="slideshow-container">
  <?php
  $repeatCount = 2;

  for ($i = 0; $i < $repeatCount; $i++) {
    echo '
          <div class="mySlides slide">
            <img class="webcover" src="static/img/cover' . $i . '.jpg" alt="cover' . $i . '"  onerror="this.src=\'static/img/errorimg.png\'; this.alt=\'Error Logo image\';">
            <img class="mobilecover" src="static/img/mcover' . $i . '.png" alt="cover' . $i . '"  onerror="this.src=\'static/img/errorimg.png\'; this.alt=\'Error Logo image\';">
                   
          </div>
           ';
  }
  ?>
  <div class="overlay"></div>
 

  <div class="text ">
    <h1>Bring your Business Online</h1>
    <h2>with <b>Mandala System</b></h2>
  </div>

  <a class="prev" onclick="plusSlides(-1)">❮</a>
  <a class="next" onclick="plusSlides(1)">❯</a>

  <div class="wave wave1"></div>
  <div class="wave wave2"></div>
  <div class="wave wave3"></div>

</div>

<script src="static/js/layout/slider.js"> </script>