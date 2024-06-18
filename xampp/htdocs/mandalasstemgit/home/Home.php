<link rel="stylesheet" href="static/css/index.css">

<?php
$controller = new Controller();
$controller->header('Home');
$controller->slider();
?>


<section class="mdabout">
    <?php
    $controller->mdmessage();
    ?>
</section>

<section class="products">
    <h1 class="animate">Our Products</h1>
    <?php
    $controller->products(3);
    ?>
</section>

<div class="customers" id="customers">
    <h1 class="animate">Our Cusomer</h1>
        <?php
        $controller->customer();
        ?>

</div>

<?php
$controller->footer();
?>

<script src="static/js/index.js">

</script>