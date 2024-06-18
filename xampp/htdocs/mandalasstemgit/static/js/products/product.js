document.addEventListener('DOMContentLoaded', async function() {
    const scriptTag = document.querySelector('script[src="static/js/products/product.js"]');
    const limitAttr = scriptTag.getAttribute('data-limit');

    const limit = parseInt(limitAttr, 10);

    try {
        const response = await fetch('static/data/product.json');
        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }
        let data = await response.json();
        if (limit > 0) {
            data = data.slice(0, limit);
        }
        renderProducts(data);
    } catch (error) {
        console.error('There has been a problem with your fetch operation:', error);
    }

    function renderProducts(products) {
        const productsContainer = document.getElementById('products-container');
        productsContainer.innerHTML = '';

        products.forEach(product => {
            const productCard = `
                <figure class="product-card">
                    <img src="${product.image}" alt="Software Image" onerror="this.src='static/img/errorimg.png'; this.alt='Error Logo image';">
                    <figcaption>
                        <h2 class="product-name">${product.name}</h2>
                        <p class="product-description">
                            ${product.description}
                        </p>
                        <div class="actionbtn">
                            <p class="product-price">${product.price}</p>
                            <button class="enquire-btn" data-id="${product.id}">Enquire</button>
                        </div>
                    </figcaption>
                </figure>
            `;
            productsContainer.insertAdjacentHTML('beforeend', productCard);
        });

        const descriptions = document.querySelectorAll('.product-description');
        
        descriptions.forEach(description => {
            description.addEventListener('click', function () {
                this.classList.toggle('expanded');
            });
        });

        const productCards = document.querySelectorAll('.enquire-btn');
        productCards.forEach(card => {
            card.addEventListener('click', function() {
                const productId = this.getAttribute('data-id');
                window.location.href = `singleproduct?id=${productId}`;
            });
        });
    }
});
