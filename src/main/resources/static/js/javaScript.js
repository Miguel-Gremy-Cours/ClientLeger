// Part for datePicker
$('.form-group.date').datepicker({
    format: 'yyyy/mm/dd',
    todayHighlight: true
}).val();

// Offres.html part
$(document).ready(function () {
    let components = $(".component");
    for (component of components) {
        if (component.innerHTML.length >= 20) {
            component.innerHTML = component.innerHTML.substring(0, 20) + "...";
        }
    }
})