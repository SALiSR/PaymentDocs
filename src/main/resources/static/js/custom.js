$(document).ready(function(){

    $('#payerINN').mask("999999999999", {placeholder: "____________"});



    $("#fillTestData").on( "click", function() {
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
        $('#recipientAccount').val('40101810400000010801');
        $('#recipientCompanyName').val('УФК (Межрайонная ИФНС России №20 по Челябинской обл.)');

        $('#paymentOrderPurpose').val('УИН ... Налог на доходы физических лиц за февраль 2017');
    });
});