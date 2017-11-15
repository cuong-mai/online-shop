$(document).ready(function() {
    showProductListTable();
});

function showProductListTable() {
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
                    data: "id",
                    render: function(data, type, row, meta) {
                        var str = "<img src='" + window.contextRoot
                            + "/resources/images/products/" + data + "/thumbnail.jpg' alt='" + row.name
                            + "' class='my-img-product-list-thumbnail'>";
                        return str;
                    },
                    orderable: false
                },
                {
                    data: "name"
                },
                {
                    data: "brand"
                },
                {
                    data: "unitPrice",
                    render: customRenderHelper.render.number(",", ".", 2, "$"),
                    type: "numeric"
                },
                {
                    data: "quantity",
                    render: function(data, type, row, meta) {
                        if (data == 0) {
                            data = "<span class='my-text-red'>Out of Stock</span>";
                        }
                        return data;
                    },
                    type: "natural"
                },
                {
                    data: "id",
                    render: function(data, type, row, meta) {

                        var editStr = "<div class='my-btn-wrapper-product-list'></div><a href='" + window.contextRoot
                            + "/manage/product/edit?id=" + data + "' "
                            + "class='btn btn-sm btn-outline-primary'><span class='fa fa-edit'></span></a></div>";

                        var viewStr = "<div class='my-btn-wrapper-product-list'><a href='" + window.contextRoot
                            + "/product/detail?id=" + data + "' "
                            + "class='btn btn-sm btn-outline-primary'><span class='fa fa-eye'></span></a></div>";

                        if (row.quantity < 1) {
                            var cartStr = "<div class='my-btn-wrapper-product-list'><a href='" + window.contextRoot
                                + "/cart/add?productId=" + data + "' "
                                + "class='btn btn-sm btn-outline-light disabled'><span class='fa fa-cart-plus'></span></a></div>";
                        } else {
                            var cartStr = "<div class='my-btn-wrapper-product-list'><a href='" + window.contextRoot
                                + "/cart/add?productId=" + data + "' "
                                + "class='btn btn-sm btn-outline-primary'><span class='fa fa-cart-plus'></span></a></div>";
                        }

                        var str = editStr + viewStr + cartStr;

                        return str;
                    },
                    orderable: false
                }
            ]
        });
    }
}
