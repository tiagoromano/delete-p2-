window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Relatorio = window.blockly.js.blockly.Relatorio || {};

/**
 * relatorio
 */
window.blockly.js.blockly.Relatorio.Executar = async function(dataHora) {

  this.cronapi.util.openReport('reports/teste.report', [{ datahora : dataHora }]);
}
