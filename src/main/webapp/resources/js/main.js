// TODO: Function to set the active menu of Nav Bar
$(document).ready(function() {
//     $("nav li").click(function() {
//        $(this).addClass("active");
//        $(this).siblings().removeClass("active");
//        console.log($(this));
//     });

    var productJsonUrl = window.contextRoot +  "/json/product/list"
        + (window.categoryId == "" ? "" : "?categoryId=" + window.categoryId);

    console.log(productJsonUrl);

    var $table = $("#productListTable");

    if ($table.length) {
        $table.DataTable({
            language: {
                lengthMenu: "Show _MENU_ products per page",
                info: "Showing _START_ to _END_ of _TOTAL_ products"
            },
            iDisplayLength: 20,
            lengthMenu: [[3, 5, 10, 20, 50, -1], ["3", "5", "10", "20", "50", "All"]],
            ajax: {
                url: productJsonUrl,
                dataSrc: ""
            },
            columns: [
                {data: "name"},
                {
                    data: "brand",
                    className: "text-center"
                },
                {
                    data: "unitPrice",
                    className: "text-center"
                },
                {
                    data: "quantity",
                    className: "text-center"
                },
            ]
        });
    }
});
