var InvoiceImporter = function() {

  function showModal() {
    var modalContainer,
      template = '../views/invoice-importer.html',
      mainContainer = $('#page-wrapper'),
      importerBtn = $('#invoice-importer-btn'),
      dialog;

    importerBtn.click(function(event) {
      event.preventDefault();
      importerBtn.parent().addClass('active');

      if (mainContainer.find('#modal-container').length == 0) {
        mainContainer.append('<div id="modal-container" />');
      }
      modalContainer = $('#modal-container');

      dialog = modalContainer.dialog({
        modal: true,
        appendTo: 'body',
        position: { my: "center", at: "top+200", of: mainContainer },
        resizable: false,
        width: 500,
        modal: true,
        draggable: false,
        title: 'Importar Notas Fiscais',
        buttons: [
          {
          	text: 'Importar', 
          	icons: {
          		primary: 'ui-icon ui-icon-play'
          	}, 
          	click: function() {
          		//
          	}
          },
          {
          	text: 'Cancelar',
          	icons: {
          		primary: 'ui-icon ui-icon-stop'
          	},
          	click: function() {
          		dialog.destroy();
          	}
          }
        ],
        open: function() {
          modalContainer.load(template);
        },
        close: function() {
          dialog.destroy();
        }
      });
    });
  }

  /**
   * Public functions
   */
  return {
    'showModal': showModal
  }

}



var invoiceImporter = new InvoiceImporter();
invoiceImporter.showModal();
