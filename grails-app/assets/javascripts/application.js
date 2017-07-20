// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better
// to create separate JavaScript files as needed.
//
//= require js/jquery
//= require js/jquery.validate
//= require js/additional-methods
//= require js/bootstrap-3.3.5
//= require js/bootstrap-custom
//= require js/bootstrap-tabcollapse-custom
//= require bootstrap-toggle
//= require js/enquire
//= require js/footable
//= require js/footable.striping
//= require js/jquery-spin
//= require js/bootstrap-multiselect
//= require js/jquery-mask
//= require js/jquery.tablesorter
//= require js/moment
//= require js/bootstrap-datetimepicker
//= require_tree .
//= require_self

if (typeof jQuery !== 'undefined') {
    (function($) {
        $(document).ajaxStart(function() {
            $('#spinner').fadeIn();
        }).ajaxStop(function() {
            $('#spinner').fadeOut();
        });
    })(jQuery);
}
