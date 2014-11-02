(function($) {
  $.fn.dwr = function(fn){
    return this.each(function() {
      var $this = $(this);
      var tmpElement = $('<div/>');
      $(this).after(tmpElement);
      $this.detach();
      fn.call(this);
      tmpElement.replaceWith($this);
    });
  };
})(jQuery);
