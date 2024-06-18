<link rel="stylesheet" href="static/css/products/productdetail.css">

<?php
function getProductById($id)
{
    $productsJson = file_get_contents('static/data/product.json');
    $products = json_decode($productsJson, true);

    foreach ($products as $product) {
        if ($product['id'] == $id) {
            return $product;
        }
    }
    return null;
}

$productId = isset($_GET['id']) ? $_GET['id'] : null;
$product = $productId ? getProductById($productId) : null;

if (!$product) {
    echo "Product not found!";
    exit;
}

?>

<div class="single-product-container">
    <figure class="product-card">
        <div class="thumbnail-wrapper">
            <?php foreach ($product['media'] as $media): ?>
                <?php if ($media['type'] === 'image'): ?>
                    <img class="product-img" src="<?php echo htmlspecialchars($media['url'], ENT_QUOTES, 'UTF-8'); ?>"
                        alt="<?php echo htmlspecialchars($product['name'], ENT_QUOTES, 'UTF-8'); ?>">
                <?php elseif ($media['type'] === 'video'): ?>
                    <video class="product-img" controls>
                        <source src="<?php echo htmlspecialchars($media['url'], ENT_QUOTES, 'UTF-8'); ?>" type="video/mp4">
                        Your browser does not support the video tag.
                    </video>
                <?php endif; ?>
            <?php endforeach; ?>
        </div>
        <figcaption class="product-detail">
            <h2 class="product-name"><?php echo htmlspecialchars($product['name'], ENT_QUOTES, 'UTF-8'); ?></h2>
            <p class="product-description">
                <?php echo htmlspecialchars($product['description'], ENT_QUOTES, 'UTF-8'); ?>
            </p>
            <div class="actionbtn">
                <p class="product-price"><?php echo htmlspecialchars($product['price'], ENT_QUOTES, 'UTF-8'); ?></p>
                <button class="enquire-btn">Enquire</button>
            </div>
        </figcaption>
    </figure>
</div>

<script>
    function changeMedia(element) {
        var mainMediaContainer = document.querySelector('.product-img');

        if (element.tagName === 'IMG') {
            mainMediaContainer.src = element.src;
            mainMediaContainer.type = 'image';
        } else if (element.tagName === 'VIDEO') {
            mainMediaContainer.src = element.querySelector('source').src;
            mainMediaContainer.type = 'video';
        }
    }

    function showMedia(element) {
        var mainMediaContainer = document.querySelector('.product-img');
        mainMediaContainer.style.display = 'block';
    }

    function hideMedia(element) {
        var mainMediaContainer = document.querySelector('.product-img');
        mainMediaContainer.style.display = 'none';
    }

</script>