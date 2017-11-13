// TODO: Function to set the active menu of Nav Bar
$(document).ready(function() {
//     $("nav li").click(function() {
//        $(this).addClass("active");
//        $(this).siblings().removeClass("active");
//        console.log($(this));
//     });

    var productJsonUrl = window.contextRoot +  "/json/product/list"
        + (window.categoryId == "" ? "" : "?categoryId=" + window.categoryId);

    var $table = $("#productListTable");

    if ($table.length) {
        $table.DataTable({
            language: {
                lengthMenu: "Show _MENU_ products per page",
                info: "Showing _START_ to _END_ of _TOTAL_ products",
            },
            iDisplayLength: 20,
            lengthMenu: [[3, 5, 10, 20, 50, -1], ["3", "5", "10", "20", "50", "All"]],
            ajax: {
                url: productJsonUrl,
                dataSrc: ""
            },
            columns: [
                {
                    data: "code",
                    render: function(data, type, row, meta) {
                        var str = "<img src='" + "http://placehold.it/100x100" + "' alt='" + ""  + "'>";
                        return str;
                    }
                },
                {
                    data: "name"
                },
                {
                    data: "brand"
                },
                {
                    data: "unitPrice"
                    // ,
                    // render: function (data, type, row, meta) {
                    //     return "&dollar;" + data;
                    // }
                },
                {
                    data: "quantity"
                },
                {
                    data: "id"
                    ,
                    render: function(data, type, row, meta) {
                        var str = "";

                        str += "<a href='" + window.contextRoot + "/product/detail?id=" + data + "' "
                            + "class='btn btn-outline-primary'><span class='fa fa-eye'></span></a> &#160;";

                        str += "<a href='" + window.contextRoot + "/SOMETHINGHERE?id=" + data + "' "
                            + "class='btn btn-outline-primary'><span class='fa fa-cart-plus'></span></a>";

                        return str;
                    }
                }
            ]
        });
    }
});
