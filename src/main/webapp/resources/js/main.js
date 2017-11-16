$(document).ready(function() {
    showProductListTable();
    showProductListTableAdmin();
});

function showProductListTable() {

    var $table = $("#productListTable");

    if ($table.length) {
        var productJsonUrl = window.contextRoot +  "/json/product/list/active"
            + (window.categoryId == "" ? "" : "?categoryId=" + window.categoryId);

        $table.DataTable({
            language: {
                lengthMenu: "Show  _MENU_ products  per page",
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
                            + "/admin/product/edit?id=" + data + "' "
                            + "class='btn btn-lg'><span class='fa fa-edit'></span></a></div>";

                        var viewStr = "<div class='my-btn-wrapper-product-list'><a href='" + window.contextRoot
                            + "/product/detail?id=" + data + "' "
                            + "class='btn btn-lg'><span class='fa fa-eye'></span></a></div>";

                        if (row.quantity < 1) {
                            var cartStr = "<div class='my-btn-wrapper-product-list'><a href='" + window.contextRoot
                                + "/cart/add?productId=" + data + "' "
                                + "class='btn btn-lg disabled'><span class='fa fa-cart-plus'></span></a></div>";
                        } else {
                            var cartStr = "<div class='my-btn-wrapper-product-list'><a href='" + window.contextRoot
                                + "/cart/add?productId=" + data + "' "
                                + "class='btn btn-lg'><span class='fa fa-cart-plus'></span></a></div>";
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

function showProductListTableAdmin() {

    var $table = $("#productListTableAdmin");

    if ($table.length) {
        var productJsonUrl = window.contextRoot +  "/admin//json/product/list/all";
            // + (window.categoryId == "" ? "" : "?categoryId=" + window.categoryId);

        $table.DataTable({
            language: {
                lengthMenu: "Show  _MENU_  products per page",
                info: "Showing _START_ to _END_ of _TOTAL_ products",
            },
            iDisplayLength: -1,
            lengthMenu: [[3, 5, 10, 20, 50, -1], ["3", "5", "10", "20", "50", "All"]],
            ajax: {
                url: productJsonUrl,
                dataSrc: ""
            },
            columns: [
                {
                    data: "id"
                },
                {
                    data: "id",
                    render: function(data, type, row, meta) {
                        var str = "<img src='" + window.contextRoot
                            + "/resources/images/products/" + data + "/thumbnail.jpg' alt='" + row.name
                            + "' class='my-img-product-list-admin-thumbnail'>";
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
                    data: "categoryId"
                },
                {
                    data: "unitPrice",
                    render: customRenderHelper.render.number(",", ".", 2, "$"),
                    type: "numeric"
                },
                {
                    data: "quantity"
                },
                {
                    data: "views"
                },
                {
                    data: "purchases"
                },
                {
                    data: "active",
                    render: function(data, type, row, meta) {
                        var status = data == true ? "checked" : "";
                        var view = "<input type='checkbox' value='" + row.id + "' class='my-activate-product-checkbox' "
                            + status + ">";
                        return view;
                    },
                    type: "numeric"
                },
                {
                    data: "id",
                    render: function(data, type, row, meta) {

                        var editView = "<div class='my-btn-wrapper-product-list'></div><a href='" + window.contextRoot
                            + "/admin/product/edit?id=" + data + "' "
                            + "class='btn btn-lg'><span class='fa fa-edit'></span></a></div>";

                        var view = editView;

                        return view;
                    },
                    orderable: false
                },
                {
                    data: "id",
                    render: function(data, type, row, meta) {

                        var view = "<div class='my-btn-wrapper-product-list'></div><a href='" + window.contextRoot
                            + "/admin/product/delete?id=" + data + "' "
                            + "class='btn btn-lg'><span class='fa fa-remove'></span></a></div>";

                        return view;
                    },
                    orderable: false
                }
            ],
            initComplete: function() {
                this.api().$(".my-activate-product-checkbox").on("change", function() {
                    var $thisCheckbox = $(this);
                    var nowChecked = $thisCheckbox.prop("checked");

                    var message = (nowChecked) ?
                        "Do you want to activate this product?" :
                        "Do you want to deactivate this product?";

                    bootbox.confirm({
                        size: "large",
                        title: "Activate/Deactivate Product",
                        message: message,
                        closeButton: false,
                        callback: function(confirmed) {
                            if (confirmed) {
                                console.log($thisCheckbox.val());

                                postRequestUrl = window.contextRoot + "/admin/product/toggleActivation?id="
                                    + $thisCheckbox.val();

                                $.ajax({
                                   url: postRequestUrl,
                                   type: "POST"
                                }).done(function(data) {
                                });

                            } else {
                                $thisCheckbox.prop("checked", !nowChecked);
                            }
                        }

                    })
                });
            }
        });
    }
}
