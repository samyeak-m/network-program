<link rel="stylesheet" href="static/css/menubar/productPage.css">
<?php

$controller = new Controller();

$controller->header("Products");
?>

<section class="product_main">
<h1 class="animate">Our Products</h1>
<div class="product_list">
<?php
$controller->products();
?>
</div>
</section>

<?php 
$controller->footer();

?>