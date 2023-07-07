/* open mobile menu */

const barMenu = document.querySelector(".bar-menu");
const navMenu = document.querySelector(".nav-menu");
const regMenu = document.querySelector(".nav-registration");

barMenu.addEventListener("click", mobileMenu);

function mobileMenu() {
    barMenu.classList.toggle("active");
    navMenu.classList.toggle("active");
    regMenu.classList.toggle("active");
}

/* close mobile menu when click on link */

const navLink = document.querySelectorAll(".nav-link");

navLink.forEach(n => n.addEventListener("click", closeMenu));

function closeMenu() {
    barMenu.classList.remove("active");
    navMenu.classList.remove("active");
    regMenu.classList.remove("active");
}

/* create insured */

function resetInsuredCreateForm() {
    document.getElementById("firstName").value = "";
    document.getElementById("lastName").value = "";
    document.getElementById("birthNumber").value = "";
    document.getElementById("email").value = "";
    document.getElementById("phone").value = "";
    document.getElementById("street").value = "";
    document.getElementById("city").value = "";
    document.getElementById("psc").value = "";
}

/* create insuranceList */

function resetInsuranceListCreateForm(){
    document.getElementById("insuranceName").value = "";
    document.getElementById("insuranceCompany").value = "";
    document.getElementById("insuranceDescription").value = "";
}

/* create insurance */

function resetInsuranceCreateForm() {
    document.getElementById("insuranceLimit").value = "";
    document.getElementById("subjectOfInsurance").value = "";
    document.getElementById("beginning").value = "";
    document.getElementById("end").value = "";
    document.getElementById("insuranceListId").selectedIndex = -1;
}





