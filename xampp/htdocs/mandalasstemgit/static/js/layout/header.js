if (page !== 'All') {
    window.onscroll = function () {
      scrollFunction();
    };
  }

  else{
    
    var header = document.getElementById("header");
    header.style.backgroundColor = "transparent";

  }

    function scrollFunction() {
      var header = document.getElementById("header");
      var dropdown = document.getElementById("dropdown-content");

      if (document.body.scrollTop > 620 || document.documentElement.scrollTop > 620) {
        header.style.backgroundColor = "var(--headcolor)";
        dropdown.style.backgroundColor = "var(--headcolor)";
        header.style.backdropFilter = "blur(15px)";
       
      } else {
        header.style.backgroundColor = "transparent";
        dropdown.style.backgroundColor = "transparent";
        header.style.backdropFilter = "blur(0px)";        

      }
    }