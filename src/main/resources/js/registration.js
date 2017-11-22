$("#country").change(function() {
    var countryId = $("#country").find("option:selected").val();
    $.get("/registration/nuts1", "nuts0=" + countryId, function(data) {
        var state = $("#state");
        var first = state.find("option:first").html();
        var options = '<option disabled="disabled" selected="selected">' + first + '</option>';
        data.forEach(function (a) {
            options += '<option value="' + a.id + '">' + a.name + '</option>';
        });
        state.html(options);
        state.prop("disabled", false);
    });
});

$("#state").change(function() {
    var stateId = $('#state').find("option:selected").val();
    $.get("/registration/nuts2", "nuts1=" + stateId, function (data) {
        var region = $("#region");
        var first = region.find("option:first").html();
        var options = '<option disabled="disabled" selected="selected">' + first + '</option>';
        data.forEach(function (a) {
            options += '<option value="' + a.id + '">' + a.name + '</option>';
        });
        region.html(options);
        region.prop("disabled", false);
    })
});

$("#region").change(function() {
    var regionId = $('#region').find("option:selected").val();
    $.get("/registration/nuts3", "nuts2=" + regionId, function (data) {
        var province = $("#province");
        var first = province.find("option:first").html();
        var options = '<option disabled="disabled" selected="selected">' + first + '</option>';
        data.forEach(function (a) {
            options += '<option value="' + a.id + '">' + a.name + '</option>';
        });
        province.html(options);
        province.prop("disabled", false);
    })
});