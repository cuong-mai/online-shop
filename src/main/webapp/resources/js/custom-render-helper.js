/*

 Modified by: Cuong Mai

 Source: DataTables
 Description:
    To display a number in the form of currency
    For example:
        230.99  --> $230.99 (with the decimal places)
        45000   --> $45,000 (without the decimal places)

 */

var customRenderHelper = {

    __htmlEscapeEntities: function(d) {
        return typeof d === 'string' ?
            d.replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/"/g, '&quot;') :
            d;
    },

    render: {
        number: function(thousands, decimal, precision, prefix, postfix) {
            return {
                display: function (d) {
                    if (typeof d !== 'number' && typeof d !== 'string') {
                        return d;
                    }

                    var negative = d < 0 ? '-' : '';
                    var flo = parseFloat(d);

                    // If NaN then there isn't much formatting that we can do - just
                    // return immediately, escaping any HTML (this was supposed to
                    // be a number after all)
                    if (isNaN(flo)) {
                        return this.__htmlEscapeEntities(d);
                    }

                    flo = flo.toFixed(precision);
                    d = Math.abs(flo);

                    var intPart = parseInt(d, 10);
                    var floatPart = precision ?
                        decimal + (d - intPart).toFixed(precision).substring(2) :
                        '';

                    if (d === Math.floor(d)) {
                        floatPart = '';
                    }

                    return negative + (prefix || '') +
                        intPart.toString().replace(
                            /\B(?=(\d{3})+(?!\d))/g, thousands
                        ) +
                        floatPart +
                        (postfix || '');
                }
            };
        },

        text: function() {
            return {
                display: this.__htmlEscapeEntities
            };
        }
    }
};