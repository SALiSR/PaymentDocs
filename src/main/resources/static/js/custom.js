$(document).ready(function(){

    /*$('#payerINN').mask("999999999999", {placeholder: "____________"});*/

    $("#fillTestDataOrder").on( "click", function() {
        $('#paymentOrderNum').val('481');
        $('#payerSumQuant').val('68678.10');

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

        $('#documentNumber').val('1-НИ от 22 апреля 2011 г.');

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
     * правила валидации mainpage
     */
    $("#form-order").validate({

        rules:{
            paymentOrderNum:{
                required: true
            },
            payerSumQuant:{
                required: true
            },
            payerINN:{
                required: true,
                minlength:9,
                maxlength:12
            },
            payerKPP:{
                required: true,
                minlength:9
            },
            payerCompanyName:{
                required: true
            },
            payerAccount:{
                required: true,
                minlength:20
            },
            payerBankName:{
                required: true
            },
            payerBankBIK:{
                required: true,
                minlength:8
            },
            payerBankAccount:{
                required: true,
                minlength:20
            },
            recipientINN:{
                required: true,
                minlength:9,
                maxlength:12
            },
            recipientKPP:{
                required: true,
                minlength:9
            },
            recipientCompanyName:{
                required: true
            },
            recipientBankAccount:{
                required: true,
                minlength:20
            },
            recipientBankName:{
                required: true
            },
            recipientBankBIK:{
                required: true,
                minlength:8
            },
            recipientAccount:{
                required: true,
                minlength:20
            },
            paymentOrderPurpose:{
                required: true,
            }
        },

        messages:{
            paymentOrderNum:{
                required: "Пожалуйста, внесите данные о номере платежного поручения"
            },
            payerSumQuant:{
                required: "Пожалуйста, внесите сумму перевода"
            },
            payerINN:{
                required: "Пожайлуста, внесите ИНН плательщика",
                minlength: "ИНН должен содержать 9-12 цифр"
            },
            payerKPP:{
                required: "Пожайлуста, внесите КПП плательщика",
                minlength: "КПП содержать 9 цифр"
            },
            payerCompanyName:{
                required: "Пожайлуста, внесите данные о наименовании Плательщика"
            },
            payerAccount:{
                required: "Пожайлуста, внесите данные о номере счета плательщика",
                minlength:"Номер счета плательщика должен содержать 20 цифр"
            },
            payerBankName:{
                required: "Пожайлуста, внесите наименование Банка плательщика"
            },
            payerBankBIK:{
                required: "Пожайлуста, внесите БИК Банка плательщика",
                minlength:"БИК должен содержать 8 цифр"
            },
            payerBankAccount:{
                required: "Пожайлуста, внесите счет БИК Банка плательщика",
                minlength:"Счет должен содержать 20 цифр"
            },
            recipientINN:{
                required: "Пожайлуста, внесите ИНН получателя",
                minlength:"ИНН должен содержать 9-12 цифр"
            },
            recipientKPP:{
                required: "Пожайлуста, внесите КПП получателя",
                minlength: "КПП должен содержать 9 цифр"
            },
            recipientCompanyName:{
                required: "Пожайлуста, внесите наименование Организации получателя"
            },
            recipientBankAccount:{
                required: "Пожайлуста, внесите счет Организации получателя",
                minlength:"Счет должен содержать 20 цифр"
            },
            recipientBankName:{
                required: "Пожайлуста, внесите наименование Банка получателя"
            },
            recipientBankBIK:{
                required: "Пожайлуста, внесите БИК Банка получателя",
                minlength:"БИК должен содержать 8 цифр"
            },
            recipientAccount:{
                required: "Пожайлуста, внесите счет Банка получателя",
                minlength:"Счет должен содержать 20 цифр"
            },
            paymentOrderPurpose:{
                required: "Пожайлуста, внесите данные о назаначении платежа",
            }
        }
    });

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
     * правила валидации invoice
     */
    $("#form-invoice").validate({

        rules:{
            documentNumber:{
                required: true
            },
            numberINN:{
                required: true,
                minlength:9,
                maxlength:12
            },
            numberKPP:{
                required: true,
                minlength:9
            },
            recipientName:{
                required: true
            },
            recipientNameBank:{
                required: true
            },
            recipientBIKBank:{
                required: true,
                minlength:8
            },
            recipientBankAccount:{
                required: true,
                minlength:20
            },
            recipientBankAccount2:{
                required: true,
                minlength:20
            },
            providerName:{
                required: true
            },
            buyerName:{
                required: true
            },
            directorName:{
                required: true
            },
            accounterName:{
                required: true
            },
            totalSum:{
                required: true
            },
        },

        messages:{
            documentNumber:{
                required: "Пожалуйста, внесите номер документа"
            },
            numberINN:{
                required: "Пожайлуста, внесите ИНН",
                minlength: "ИНН должен содержать 9-12 цифр"
            },
            numberKPP:{
                required: "Пожайлуста, внесите КПП",
                minlength: "КПП должен содержать 10 цифр"
            },
            recipientName:{
                required: "Пожайлуста, внесите данные о наименовании Получателя"
            },
            recipientNameBank:{
                required: "Пожайлуста, внесите наименование Банка получателя"
            },
            recipientBIKBank:{
                required: "Пожайлуста, внесите БИК Банка получателя",
                minlength:"Счет должен содержать 8 цифр"
            },
            recipientBankAccount:{
                required: "Пожайлуста, внесите счет Организации получателя",
                minlength:"Счет должен содержать 20 цифр"
            },
            recipientBankAccount2:{
                required: "Пожайлуста, внесите счет Организации получателя",
                minlength:"Счет должен содержать 20 цифр"
            },
            providerName:{
                required: "Пожайлуста, внесите наименование Организации поставщика"
            },
            buyerName:{
                required: "Пожайлуста, внесите наименование Организации покупателя"
            },
            directorName:{
                required: "Пожайлуста, внесите ФИО руководителя организации"
            },
            accounterName:{
                required: "Пожайлуста, внесите ФИО бухгалтера организации"
            },
            totalSum:{
                required: "Пожалуйста, внесите сумму перевода"
            },
        }
    });
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



