<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Page</title>
    <style>
        .product-page {
            width: 80dvw;
            display: flex;
            flex-direction: column;
            align-items: start;
        }

        .image-gallery {
            display: flex;
            flex-direction: column;
            align-items: start;
        }

        .main-image {
            width: 400px;
            height: 400px;
            overflow: hidden;
            cursor: zoom-in;
            margin-bottom: 20px;
            z-index: 1;
        }

        .main-image img, .main-image video {
            width: 100%;
            height: 100%;
            object-fit: cover;
        }

        .thumbnail-wrapper {
            position: relative;
            width: 350px;
            margin-top: 10px;
        }

        .thumbnail-images {
            display: flex;
            justify-content: flex-start;
            overflow-x: auto;
            cursor: pointer;
            scrollbar-width: none; 
            -ms-overflow-style: none;
        }

        .thumbnail-images::-webkit-scrollbar {
            display: none;
        }

        .thumbnail-images img, .thumbnail-images video {
            width: 60px;
            height: 60px;
            margin: 0 5px;
            object-fit: cover;
        }

        .thumbnail-images img:hover, .thumbnail-images video:hover {
            box-shadow: 2px 3px 5px rgba(0, 0, 0, 0.9);
        }

        .arrow {
            position: absolute;
            top: 50%;
            transform: translateY(-50%);
            background-color: rgba(0, 0, 0, 0.5);
            color: white;
            border: none;
            cursor: pointer;
            z-index: 10;
            font-size: 18px;
            padding: 20px 8px;
        }

        .arrow:hover{
            background-color: rgba(0, 0, 0, 0.9);
        }

        .arrow-left {
            left: 0;
        }

        .arrow-right {
            right: 0;
        }

        .zoom-container {
            width: 400px;
            height: 400px;
            overflow: hidden;
            border: 1px solid #ccc;
            display: block;
            opacity: 0;
            z-index: 5;
            margin-left: 5px;
        }

        .zoom-container img {
            width: 100%;
            height: 100%;
            object-fit: cover;
        }

        .container {
            display: flex;
            justify-content: start;
        }
    </style>
</head>
<body>
    <div class="product-page">
        <div class="image-gallery">
            <div class="container">
                <div class="main-image" id="mainImageContainer" onmousemove="moveZoom(event)" onmouseover="showZoomedImage()" onmouseout="hideZoomedImage()">
                    <img id="mainImage" src="static/img/logo.png" alt="Main Product Image">
                    <video id="mainVideo" controls style="display: none;">
                        <source src="" type="video/mp4">
                    </video>
                </div>
                <div class="zoom-container" id="zoomContainer">
                    <img id="zoomedImage" src="static/img/logo.png" alt="Zoomed Image">
                </div>
            </div>
            <div class="thumbnail-wrapper">
                <button class="arrow arrow-left" id="arrowLeft" onclick="scrollThumbnails('left')">&lt;</button>
                <div class="thumbnail-images" id="thumbnailContainer">
                    <img src="static/img/logo.png" alt="Thumbnail 1" class="thumb" onclick="changeToImage(this)">
                    <img src="static/img/img1.jpg" alt="Thumbnail 2" class="thumb" onclick="changeToImage(this)">
                    <video class="thumb" onclick="changeToVideo(this)">
                        <source src="static/img/stall.mp4" type="video/mp4">
                    </video>
                    <img src="static/img/cover0.jpg" alt="Thumbnail 3" class="thumb" onclick="changeToImage(this)">
                    <img src="static/img/img1.jpg" alt="Thumbnail 4" class="thumb" onclick="changeToImage(this)">
                    <video class="thumb" onclick="changeToVideo(this)">
                        <source src="static/img/gallery.mp4" type="video/mp4">
                    </video>
                </div>
                <button class="arrow arrow-right" id="arrowRight" onclick="scrollThumbnails('right')">&gt;</button>
            </div>
        </div>
    </div>
    <script>
        function changeToImage(element) {
            var mainImageContainer = document.getElementById('mainImageContainer');
            var mainImage = document.getElementById('mainImage');
            var zoomedImage = document.getElementById('zoomedImage');
            var mainVideo = document.getElementById('mainVideo');

            mainImage.src = element.src;
            zoomedImage.src = element.src;

            mainImage.style.display = 'block';
            mainVideo.style.display = 'none';
            mainImageContainer.style.cursor = 'zoom-in';
        }

        function changeToVideo(element) {
            var mainImageContainer = document.getElementById('mainImageContainer');
            var mainVideo = document.getElementById('mainVideo');
            var mainImage = document.getElementById('mainImage');
            var source = element.querySelector('source');

            mainVideo.src = source.src;
            mainVideo.load();

            mainImage.style.display = 'none';
            mainVideo.style.display = 'block';
            mainImageContainer.style.cursor = 'default';
        }

        function showZoomedImage() {
            var zoomContainer = document.getElementById('zoomContainer');
            if (document.getElementById('mainImage').style.display !== 'none') {
                zoomContainer.style.opacity = '1';
            }
        }

        function hideZoomedImage() {
            var zoomContainer = document.getElementById('zoomContainer');
            zoomContainer.style.opacity = '0';
        }

        function moveZoom(event) {
            var zoomedImage = document.getElementById('zoomedImage');
            var rect = event.target.getBoundingClientRect();
            var x = event.clientX - rect.left;
            var y = event.clientY - rect.top;
            var xPercent = (x / rect.width) * 100;
            var yPercent = (y / rect.height) * 100;
            zoomedImage.style.transformOrigin = `${xPercent}% ${yPercent}%`;
            zoomedImage.style.transform = "scale(2)";
        }

        function checkOverflow() {
            var thumbnailContainer = document.getElementById('thumbnailContainer');
            var arrowLeft = document.getElementById('arrowLeft');
            var arrowRight = document.getElementById('arrowRight');

            arrowLeft.style.display = thumbnailContainer.scrollLeft > 0 ? 'block' : 'none';
            arrowRight.style.display = thumbnailContainer.scrollWidth > thumbnailContainer.clientWidth + thumbnailContainer.scrollLeft ? 'block' : 'none';
        }

        function scrollThumbnails(direction) {
            var thumbnailContainer = document.getElementById('thumbnailContainer');
            var scrollAmount = 100;

            if (direction === 'left') {
                thumbnailContainer.scrollBy({ left: -scrollAmount, behavior: 'smooth' });
            } else if (direction === 'right') {
                thumbnailContainer.scrollBy({ left: scrollAmount, behavior: 'smooth' });
            }

            setTimeout(checkOverflow, 300);
        }

        document.getElementById('thumbnailContainer').addEventListener('scroll', checkOverflow);
        window.addEventListener('resize', checkOverflow);
        window.addEventListener('load', checkOverflow);
    </script>
</body>
</html>
