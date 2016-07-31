/**
 * Created by tuyenhx on 8/1/16.
 */
$(function() {
    var uploader = document.getElementById("uploader");
    var uploadForm = document.getElementById("upload-form");
    $(uploader).on("change", function() {
        // var data = new FormData();
        // data.append("file", uploader.files[0]);
        // $.ajax({
        //     type: "POST",
        //     url: "/upload",
        //     processData: false,
        //     cache: false,
        //     contentType: false,
        //     data: data,
        //     success: function (res) {
        //
        //     },
        //     error: function(err) {
        //         alert(err.message);
        //     }
        // });

        $(uploadForm).submit();

    });
});