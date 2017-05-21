/*alert("!!!");*/
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
$(document).ready(function() {
    $('#form-order').bootstrapValidator({
        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            paymentOrderNum: {
                validators: {
                    notEmpty: {
                        message: 'Введите, плиз, номер документа'
                    }
                }
            },
            payerSumQuant: {
                validators: {
                    notEmpty: {
                        message: 'Введите, плиз, Сумму платежа'
                    }
                }
            },
            payerINN: {
                validators: {
                    stringLength: {
                        min: 9,
                        max:12,
                        message: 'Введите, плиз, ИНН плательщика (9-12 цифр)'
                    },
                    notEmpty: {
                        message: 'Введите, плиз, ИНН плательщика (9-12 цифр)'
                    }
                }
            },
            payerKPP: {
                validators: {
                    stringLength: {
                        min: 9,
                        message: 'Введите, плиз, КПП плательщика (9 цифр)'
                    },
                    notEmpty: {
                        message: 'Введите, плиз, КПП плательщика (9 цифр)'
                    }
                }
            },
            payerCompanyName: {
                validators: {
                    notEmpty: {
                        message: 'Введите, плиз, наименование организации плательщика'
                    }
                }
            },
            payerAccount: {
                validators: {
                    stringLength: {
                        min: 20,
                        message: 'Номер счета плательщика должен содержать 20 цифр'
                    },
                    notEmpty: {
                        message: 'Номер счета плательщика должен содержать 20 цифр'
                    }
                }
            },
            payerBankName: {
                validators: {
                    notEmpty: {
                        message: 'Введите, плиз, наименование банка плательщика'
                    }
                }
            },
            payerBankBIK: {
                validators: {
                    stringLength: {
                        min: 8,
                        message: 'Введите, плиз, БИК банка плательщика (8 цифр)'
                    },
                    notEmpty: {
                        message: 'Введите, плиз, БИК банка плательщика (8 цифр)'
                    }
                }
            },
            payerBankAccount: {
                validators: {
                    stringLength: {
                        min: 20,
                        message:'Введите, плиз, номер счета банка плательщика (20 цифр)'
                    },
                    notEmpty: {
                        message: 'Введите, плиз, номер счета банка плательщика (20 цифр)'
                    }
                }
            },
            recipientINN: {
                validators: {
                    stringLength: {
                        min: 9,
                        max: 12,
                        message:'Введите, плиз, ИНН получателя (9-12 цифр)'
                    },
                    notEmpty: {
                        message: 'Введите, плиз, ИНН получателя (9-12 цифр)'
                    }
                }
            },
            recipientKPP: {
                validators: {
                    stringLength: {
                        min: 9,
                        message:'Введите, плиз, КПП получаетеля (9 цифр)'
                    },
                    notEmpty: {
                        message: 'Введите, плиз, КПП получателя (9 цифр)'
                    }
                }
            },
            recipientCompanyName: {
                validators: {
                    notEmpty: {
                        message: 'Введите, плиз, наименование организации получателя'
                    }
                }
            },
            recipientBankAccount: {
                validators: {
                    stringLength: {
                        min: 20,
                        message:'Введите, плиз, номер счета плательщика (20 цифр)'
                    },
                    notEmpty: {
                        message:'Введите, плиз, номер счета плательщика (20 цифр)'
                    }
                }
            },
            recipientBankName: {
                validators: {
                    notEmpty: {
                        message: 'Введите, плиз, наименование организации получателя'
                    }
                }
            },
            recipientBankBIK: {
                validators: {
                    stringLength: {
                        min: 8,
                        message: 'Введите, плиз, БИК банка получателя (8 цифр)'
                    },
                    notEmpty: {
                        message: 'Введите, плиз, БИК банка получателя (8 цифр)'
                    }
                }
            },
            recipientAccount: {
                validators: {
                    stringLength: {
                        min: 20,
                        message:'Введите, плиз, номер счета банка получателя (20 цифр)'
                    },
                    notEmpty: {
                        message:'Введите, плиз, номер счета банка получателя (20 цифр)'
                    }
                }
            },
            paymentOrderPurpose: {
                validators: {
                    notEmpty: {
                        message:'Введите, плиз, описание платежа'
                    }
                }
            }
        }
    })
        .on('success.form.bv', function(e) {
            $('#success_message').slideDown({ opacity: "show" }, "slow") // Do something ...
            $('#contact_form').data('bootstrapValidator').resetForm();

            // Prevent form submission
            e.preventDefault();

            // Get the form instance
            var $form = $(e.target);

            // Get the BootstrapValidator instance
            var bv = $form.data('bootstrapValidator');

            /*// Use Ajax to submit form data
            $.post($form.attr('action'), $form.serialize(), function(result) {
                console.log(result);
            }, 'json');*/
        });
});

/**
 * validation option for invoice
 */
$(document).ready(function() {
    $('#form-invoice').bootstrapValidator({
        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        /*валидация mainpage*/
        fields: {
            documentNumber: {
                validators: {
                    notEmpty: {
                        message:'Введите, плиз, номер и дату документа'
                    }
                }
            },
            numberINN: {
                validators: {
                    stringLength: {
                        min: 9,
                        max: 12,
                        message:'Введите, плиз, ИНН получателя (9-12 цифр)'
                    },
                    notEmpty: {
                        message: 'Введите, плиз, ИНН получателя (9-12 цифр)'
                    }
                }
            },
            numberKPP: {
                validators: {
                    stringLength: {
                        min: 9,
                        message: 'Введите, плиз, КПП получателя (9 цифр)'
                    },
                    notEmpty: {
                        message: 'Введите, плиз, КПП получателя (9 цифр)'
                    }
                }
            },
            recipientName: {
                validators: {
                    notEmpty: {
                        message: 'Введите, плиз, наименование организации получателя'
                    }
                }
            },
            recipientNameBank: {
                validators: {
                    notEmpty: {
                        message: 'Введите, плиз, наименование организации получателя'
                    }
                }
            },
            recipientBIKBank: {
                validators: {
                    stringLength: {
                        min: 8,
                        message: 'Введите, плиз, БИК банка получателя (8 цифр)'
                    },
                    notEmpty: {
                        message: 'Введите, плиз, БИК банка получателя (8 цифр)'
                    }
                }
            },
            recipientBankAccount: {
                validators: {
                    stringLength: {
                        min: 20,
                        message:'Введите, плиз, номер счета банка получателя (20 цифр)'
                    },
                    notEmpty: {
                        message:'Введите, плиз, номер счета банка получателя (20 цифр)'
                    }
                }
            },
            recipientBankAccount2: {
                validators: {
                    stringLength: {
                        min: 20,
                        message:'Введите, плиз, номер счета получателя (20 цифр)'
                    },
                    notEmpty: {
                        message:'Введите, плиз, номер счета получателя (20 цифр)'
                    }
                }
            },
            providerName: {
                validators: {
                    notEmpty: {
                        message: 'Введите, плиз, данные организации поставщика'
                    }
                }
            },
            buyerName: {
                validators: {
                    notEmpty: {
                        message: 'Введите, плиз, данные организации покупателя'
                    }
                }
            },
            directorName: {
                validators: {
                    notEmpty: {
                        message: 'Введите, плиз, ФИО директора орагнизации'
                    }
                }
            },
            accounterName: {
                validators: {
                    notEmpty: {
                        message: 'Введите, плиз, ФИО бухгалтера орагнизации'
                    }
                }
            }
        }
    })
        .on('success.form.bv', function(e) {
            $('#success_message').slideDown({ opacity: "show" }, "slow") // Do something ...
            $('#contact_form').data('bootstrapValidator').resetForm();

            // Prevent form submission
            e.preventDefault();

            // Get the form instance
            var $form = $(e.target);

            // Get the BootstrapValidator instance
            var bv = $form.data('bootstrapValidator');

            /*// Use Ajax to submit form data
             $.post($form.attr('action'), $form.serialize(), function(result) {
             console.log(result);
             }, 'json');*/
        });
});

