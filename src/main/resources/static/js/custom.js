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
});

