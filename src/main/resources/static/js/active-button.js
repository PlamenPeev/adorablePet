const navItems = document.querySelectorAll(".nav-item");
for (let i = 0; i < navItems.length; i++) {
    navItems[i].addEventListener("click", function() {
        this.classList.add("active");
    });
}