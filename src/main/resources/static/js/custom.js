//alert("!!!");
$(document).ready(function(){

    /*$('#payerINN').mask("999999999999", {placeholder: "____________"});*/

    $("#fillTestDataOrder").on( "click", function() {
        $('#paymentOrderNum').val('');///1234 было по умолчанию
        $('#payerSumQuant').val('');

        $('#payerINN').val('7505005550');
        $('#payerKPP').val('750501001');
        $('#payerCompanyName').val('ООО \"Рассвет\"');
        $('#payerAccount').val('40703920007330010255');
        $('#payerBankName').val('АО \"Банк\" Г.Магнитогорск');
        $('#payerBankBIK').val('047501711');
        $('#payerBankAccount').val('30101910500000000811');

        $('#recipientBankName').val('ГРКЦ ГУ БАНКА РОССИИ ПО ЧЕЛЯБИНСКОЙ ОБЛ. Г. МАГНИТОГОРСК');
        $('#recipientBankBIK').val('0475010011');
        $('#recipientBankAccount').val('');
        $('#recipientINN').val('7459000015');
        $('#recipientKPP').val('745901001');
        $('#recipientBankAccount').val('40103810400000010307');
        $('#recipientAccount').val('40101810400000010801');
        $('#recipientCompanyName').val('УФК (Межрайонная ИФНС России №20 по Челябинской обл.)');

        $('#paymentOrderPurpose').val('УИН ... Налог на доходы физических лиц за февраль 2017');
    });

    $("#fillTestDataInvoice").on( "click", function() {
        $('#recipientNameBank').val('АО \"ВТБ 24\" г.Москва');
        $('#numberINN').val('7710701721');
        $('#numberKPP').val('771001001');
        $('#recipientName').val('ООО \"Система\"');
        $('#recipientBIKBank').val('44525716');
        $('#recipientBankAccount').val('30101810100000000112');
        $('#recipientBankAccount2').val('40702810471000007231');

        $('#documentNumber').val(''); //1-НИ от 22 апреля 2011 г. - было по умолчанию

        $('#providerName').val('ООО \"Система\", ИНН 7710701721, КПП 771001001, 125047, Москва г, Тверская-Ямская 4-я ул, дом № 11, строение 1, тел.: (495) 121-11-88, факс: (495) 121-11-88');
        $('#buyerName').val('ООО \"НЕРО ГРУП\", ИНН 7716599123, КПП 771601001, 107497, Москва г, Щелковское ш, дом № 65, строение 3');

        $('#directorName').val('Кожевин Д.А.');
        $('#accounterName').val('Иванова И.О.');
        $('#countPosition').val('1');
        $('#totalSum').val('700 000,00');
        $('#totalSumString').val('Семьсот тысяч рублей 00 копеек');
        $('#totalSumNDS').val('106 779,70');
    });

    //Добавленны для автоматическиого заполнения задезейбленных полей при загрузку страницы,
    //как будет добавленна валидация.
    $("#fillTestDataOrder").trigger( "click");
    $("#fillTestDataInvoice").trigger( "click");

    /**
     * маски для mainpage (order)
     */
    $('#payerSumQuant').mask("###0.00", {reverse: true});
    $('#payerINN').mask("999999999999");
    $('#payerKPP').mask("999999999");
    $('#payerAccount').mask("999999999999999999999");
    $('#payerBankBIK').mask("99999999");
    $('#payerBankAccount').mask("99999999999999999999");
    $('#recipientINN').mask("999999999999");
    $('#recipientKPP').mask("999999999");
    $('#recipientBankAccount').mask("99999999999999999999");
    $('#recipientBankBIK').mask("99999999");
    $('#recipientAccount').mask("999999999999999999999");

    /**
     * маски для invoce
     */
    $('#numberINN').mask("9999999999999");
    $('#numberKPP').mask("999999999");
    $('#recipientBIKBank').mask("99999999");
    $('#recipientBankAccount').mask("99999999999999999999");
    $('#recipientBankAccount2').mask("99999999999999999999");
    $('#totalSum').mask("# ##0.00", {reverse: true});
});

/**
 * Валидация mainpage
 */

$( document ).ready( function () {
    $( "#form-order" ).validate({
        rules: {
            paymentOrderNum: "required",
            payerSumQuant: "required",
            payerINN: {
                required: true,
                minlength: 9,
                maxlength: 12,
            },
            payerKPP: {
                required: true,
                minlength: 9
            },
            payerCompanyName: "required",
            payerAccount: {
                required: true,
                minlength: 20
            },
            payerBankName: "required",
            payerBankBIK: {
                required: true,
                minlength: 8
            },
            payerBankAccount: {
                required: true,
                minlength: 20
            },
            recipientINN: {
                required: true,
                minlength: 9,
                maxlength: 12,
            },
            recipientKPP: {
                required: true,
                minlength: 9
            },
            recipientCompanyName: "required",
            recipientBankAccount: {
                required: true,
                minlength: 20
            },
            recipientBankName: "required",
            recipientBankBIK: {
                required: true,
                minlength: 8
            },
            recipientAccount: {
                required: true,
                minlength: 20
            },
            paymentOrderPurpose: "required",
        },
        messages: {
            paymentOrderNum: "Введите, плиз, номер документа",
            payerSumQuant: "Введите, плиз, Сумму платежа",
            payerINN: "Введите, плиз, ИНН плательщика (9-12 цифр)",
            payerKPP: "Введите, плиз, КПП плательщика (9 цифр)",
            payerCompanyName: "Введите, плиз, наименование организации плательщика",
            payerAccount: "Номер счета плательщика должен содержать 20 цифр",
            payerBankName: "Введите, плиз, наименование банка плательщика",
            payerBankBIK: "Введите, плиз, БИК банка плательщика (8 цифр)",
            payerBankAccount: "Введите, плиз, номер счета банка плательщика (20 цифр)",
            recipientINN: "Введите, плиз, ИНН получателя (9-12 цифр)",
            recipientKPP: "Введите, плиз, КПП получаетеля (9 цифр)",
            recipientCompanyName: "Введите, плиз, наименование организации получател",
            recipientBankAccount: "Введите, плиз, номер счета плательщика (20 цифр)",
            recipientBankName: "Введите, плиз, наименование организации получателя",
            recipientBankBIK: "Введите, плиз, БИК банка получателя (8 цифр)",
            recipientAccount: "Введите, плиз, номер счета банка получателя (20 цифр)",
            paymentOrderPurpose: "Введите, плиз, описание платежа"

        },
        errorElement: "em",
        errorPlacement: function ( error, element ) {
            // Add the `help-block` class to the error element
            error.addClass( "help-block" );

            if ( element.prop( "type" ) === "checkbox" ) {
                error.insertAfter( element.parent( "label" ) );
            } else {
                error.insertAfter( element );
            }
        },
        highlight: function ( element, errorClass, validClass ) {
            $( element ).parents( ".col-md-9" ).addClass( "has-error" ).removeClass( "has-success" );
        },
        unhighlight: function (element, errorClass, validClass) {
            $( element ).parents( ".col-md-9" ).addClass( "has-success" ).removeClass( "has-error" );
        }
    }
    );
} );

/**
 * Валидация invoice
 */
$( document ).ready( function () {
    $( "#form-invoice" ).validate({
            rules: {
                documentNumber: "required",
                numberINN: {
                    required: true,
                    minlength: 9,
                    maxlength: 12,
                },
                numberKPP: {
                    required: true,
                    minlength: 9
                },
                recipientName: "required",
                recipientNameBank: "required",
                recipientBIKBank: {
                    required: true,
                    minlength: 8
                },
                recipientBankAccount: {
                    required: true,
                    minlength: 20
                },
                recipientBankAccount2: {
                    required: true,
                    minlength: 20
                },
                providerName: "required",
                buyerName: "required",
                directorName: "required",
                accounterName: "required",
            },
            messages: {
                documentNumber: "Введите, плиз, номер документа",
                numberINN: "Введите, плиз, ИНН плательщика (9-12 цифр)",
                numberKPP: "Введите, плиз, КПП плательщика (9 цифр)",
                recipientName: "Введите, плиз, наименование организации плательщика",
                recipientNameBank: "Введите, плиз, получателя средств",
                recipientBankName: "Введите, плиз, наименование Банка получателя",
                recipientBIKBank: "Введите, плиз, БИК банка плательщика (8 цифр)",
                recipientBankAccount: "Введите, плиз, номер счета банка получателя (20 цифр)",
                recipientBankAccount2: "Введите, плиз, номер счета Банка получателя (20 цифр)",
                providerName: "Введите, плиз, наименование организации поставщика",
                buyerName: "Введите, плиз, наименование организации покупателя",
                directorName: "Введите, плиз, ФИО директора",
                accounterName: "Введите, плиз, ФИО бухгалтера",
            },
            errorElement: "em",
            errorPlacement: function ( error, element ) {
                // Add the `help-block` class to the error element
                error.addClass( "help-block" );

                if ( element.prop( "type" ) === "checkbox" ) {
                    error.insertAfter( element.parent( "label" ) );
                } else {
                    error.insertAfter( element );
                }
            },
            highlight: function ( element, errorClass, validClass ) {
                $( element ).parents( ".col-md-9" ).addClass( "has-error" ).removeClass( "has-success" );
            },
            unhighlight: function (element, errorClass, validClass) {
                $( element ).parents( ".col-md-9" ).addClass( "has-success" ).removeClass( "has-error" );
            }
        }
    );
} );

