// Part for datePicker
$(document).ready(function () {
    $('.form-group.date').datepicker({
        format: 'yyyy/mm/dd',
        todayHighlight: true
    }).val();
})

// Offres.html part
$(document).ready(function () {
    for (component of $('.offres .down .left .component')) {
        if (component.innerHTML.length >= 20) {
            component.innerHTML = component.innerHTML.substring(0, 20) + "...";
        }
    }
    for (component of $('.offres .down .right .component')) {
        if (component.innerHTML.length >= 20) {
            component.innerHTML = component.innerHTML.substring(0, 20) + "...";
        }
    }
})

// Offre.html part (Detailed Offre page)
$(document).ready(function () {
    let components = $('.offreDetail .component').not(":last");
    for (component of components) {
        component.style.setProperty("border-bottom", "solid #000000 1pt");
    }
})