<?php

class Controller {
    public function index() {
        include __DIR__ . "/../home/home.php";
    }    

    public function abouts() {
        include __DIR__ . '/../home/menubar/abouts.php';
    }

    public function header($page) {
        include __DIR__ . '/../home/layout/header.php';
    }

    public function footer() {
        include __DIR__ . '/../home/layout/footer.php';
    }

    public function slider() {
        include __DIR__ . '/../home/layout/slider.php';
    }

    public function mdmessage() {
        include __DIR__ . '/../home/aboutus/mdmessage.php';
    }

    public function companyprofile() {
        include __DIR__ . '/../home/aboutus/companyprofile.php';
    }

    public function sucess() {
        include __DIR__ . '/../home/aboutus/sucess.php';
    }

    public function customer() {
        include __DIR__ . '/../home/customer/customers.php';
    }

    public function products($limit = -1) {
        include __DIR__ . '/../home/products/product.php';
    }

    public function allproducts() {
        include __DIR__ . '/../home/menubar/allproducts.php';
    }

    public function singleproduct($id) {
        $productId = $id;
        include __DIR__ . '/../home/products/singleproduct.php';
    }

    public function productdetail($productId) {
        $id = $productId;
        include __DIR__ . '/../home/products/productdetail.php';
    }

    public function gallery() {
        include __DIR__ . '/../home/index/gallery.php';
    }

    public function contact() {
        include __DIR__ . '/../home/index/contact.php';
    }

    public function login() {
        include __DIR__ . '/../home/log/login.php';
    }

    public function register() {
        include __DIR__ . '/../home/log/register.php';
    }

    public function logout() {
        include __DIR__ . '/../home/log/logout.php';
    }

    public function admin() {
        include __DIR__ . '/../home/admin/admin.php';
    }

    public function test() {
        include __DIR__ . "/../home/test/index.php";
    }

    public function notFound()
    {
        include __DIR__ . "/../home/error/404.php";
        exit;
    }

    public function error505($errorMessage = "Internal Server Error")
    {
        include __DIR__ . "/../home/error/505.php";
        echo "500 Internal Server Error: " . $errorMessage;
        exit;
    }

}
