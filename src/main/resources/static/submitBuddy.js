jQuery(document).ready(function($) {
    $("#buddy-form").submit(function(event) {

        // Prevent the form from submitting via the browser.
        event.preventDefault();
        addViaAjax();

    });
});

function addViaAjax() {
    var data = {}
    data["name"] = $("#name").val();
    data["address"] = $("#address").val();
    data["phoneNumber"] = $("#phoneNumber").val();


    $.ajax({
        type : "POST",
        contentType : "application/json",
        url : "/buddies",
        data : JSON.stringify(data),
        dataType : 'json',
        timeout : 100000,
        success : function(data) {
            console.log("SUCCESS: ", data);
            $("#result").append("Added buddy to address book");
        },
        error : function(e) {
            console.log("ERROR: ", e);
        },
        done : function(e) {
            console.log("DONE");

        }
    });
}