$(document).ready(function() {
    $.get("/registration/nuts0", function(data) {
        var state = $("#country");
        var first = state.find("option:first").html();
        var options = '<option disabled="disabled" selected="selected">' + first + '</option>';
        data.forEach(function (a) {
            options += '<option value="' + a.id + '">' + a.name + '</option>';
        });
        state.html(options);
        state.prop("disabled", false);
    });

    $.get("/user/profile/zodiac", function (data) {
        $("#zodiac-text").html("Your zodiac sign is " + data + ".");
    });

    $.get("/user/profile/socionicsType", function (data) {
        if (data === null || data === "") {
            $("#socionics-type-text").hide();
        } else {
            $("#socionics-type-text").html("Your socionics type is " + data + ".");
        }
    });

    $.get("/user/profile/socionicsMessage", function (data) {
        $("#socionics-type-message").html(data);
    });

    $.get("/user/profile/socionicsResult", function (data) {
        var canvas = $("#user-chart");
        if (data === null || data === "") {
            canvas.hide();
            $("#btn-socionics-test").html("Take socionics test");
            return;
        }

        var ev = data.extrovertValue;
        var sv = data.sensingValue;
        var tv = data.thinkingValue;
        var pv = data.perceivingValue;
        new Chart(canvas, {
            type: 'radar',
            data: {
                labels: ["Extrovert", "Sensing", "Thinking", "Perceiving",
                    "Introvert", "Intuitive", "Feeling", "Judging"],
                datasets: [{
                    data: [ev, sv, tv, pv, 1-ev, 1-sv, 1-tv, 1-pv],
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)'
                    ],
                    borderColor: [
                        'rgba(255,99,132,1)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                legend: {
                    display: false
                },
                scale: {
                    ticks: {
                        min: 0,
                        max: 1
                    }
                }
            }
        });
    });
});

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