let navItemsBar = document.querySelectorAll('.nav-item');
for (let i = 0; i < navItemsBar.length; i++) {
    navItemsBar[i].addEventListener('click', function() {
        this.classList.add('active');
    });
}