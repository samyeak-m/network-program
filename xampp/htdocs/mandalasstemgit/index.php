<?php 
require_once "app/controller.php";
require_once "app/model.php";

$requestUrl = $_SERVER['REQUEST_URI'];
$parsedUrl = parse_url($requestUrl);
$requestPath = substr($parsedUrl['path'], 14);
parse_str($parsedUrl['query'] ?? '', $queryParams);

$routes = [
    '/' => 'Controller@index',
    '/abouts' => 'Controller@abouts',
    '/allproducts' => 'Controller@allproducts',
    '/singleproduct' => 'Controller@singleproduct',
    '/test' => 'Controller@test',

];

$controllerMethod = $routes[$requestPath] ?? null;

try {
    if ($controllerMethod !== null) {
        list($controllerName, $methodName) = explode('@', $controllerMethod);

        spl_autoload_register(function ($class) {
            include 'app/controller.php';
        });

        if (class_exists($controllerName) && method_exists($controllerName, $methodName)) {
            $controller = new $controllerName();
            if ($methodName === 'singleproduct' && isset($queryParams['id'])) {
                $controller->$methodName($queryParams['id']);
            } else {
                $controller->$methodName();
            }
        } else {
            $controller = new Controller();
            $controller->notFound();
        }
    } else {
        $controller = new Controller();
        $controller->notFound();
    }
} catch (Exception $e) {
    $controller = new Controller();
    $controller->error505($e->getMessage());
}
