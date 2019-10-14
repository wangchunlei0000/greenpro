<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<title>绿色金融网站</title>
<!-- Meta tag Keywords -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Enlightenment Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all">
<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all">
<link href="css/simpleLightbox.css" rel="stylesheet" type="text/css" />
<link href="css/style1.css" rel="stylesheet" type="text/css" media="all">
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
<link href="//fonts.googleapis.com/css?family=Open+Sans+Condensed:300,300i,700" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
</head>
<body>


<script src="js/TweenMax.min.js"></script> 
<script>
$(document).ready(function() {
  var imgWidth = $(".slideshow__image").width(),
    $slider = $(".slideshow__container"),
    $nextButton = $(".slideshow__next"),
    $prevButton = $(".slideshow__prev"),
    closeBlock = $(".slideshow__block"),
    slideInBlock = (".slideshow__slidein"),
    slideNext = $('.slideshow__forward').find('.slideshow__slidein'),
    slideBack = $('.slideshow__back').find('.slideshow__slidein'),
    clickCount = 0,
    clickCountImg = 1;

  $nextButton.click(function() {
    var circle = $(this).find('.circle'),
      line = $(this).find('.line'),
      block = $(this).parent().find('.slideshow__block'),
      slideIn = $(this).parent().find('.slideshow__slidein'),
      tl = new TimelineMax({
        onComplete: tlComplete
      }),
      tl2 = new TimelineMax();

    tl.set(circle, {
        x: 15,
        y: 15,
        scale: 0
      })
      .set(slideIn, {
        right: -350,
        opacity: 1
      }, 0)
      .set(block, {
        right: 270,
        opacity: 0
      }, 0)
      .set($nextButton, {
        zIndex: 1
      }, 0)
      .to(circle, 0.5, {
        scale: 1,
        transformOrigin: "50%, 50%",
        opacity: 1
      }, 0)
      .to(circle, 0.3, {
        opacity: 0
      })
      .to(line, 0.3, {
        scale: 0,
        transformOrigin: "50%, 50%"
      }, 0)
      .set(circle, {
        scale: 0,
        opacity: 0
      });

    function tlComplete() {
      tl2.to(slideIn, 0.5, {
          right: 0
        })
        .to(block, 0.5, {
          right: 350,
          opacity: 1
        }, 0)
    };

    function getLineback() {
      TweenMax.to(line, 0.3, {
        scale: 1,
        opacity: 1,
        delay: 0.5
      });
    };

    closeBlock.click(function() {
      tl2.reverse();
    });

    closeBlock.click(getLineback);

    $prevButton.click(function() {
      tl2.reverse();
    });

    $prevButton.click(getLineback);

  });

  $prevButton.click(function() {
    var circle = $(this).find('.circle'),
      line = $(this).find('.line'),
      block = $(this).parent().find('.slideshow__block'),
      slideIn = $(this).parent().find('.slideshow__slidein'),
      tl = new TimelineMax({
        onComplete: tlComplete
      }),
      tl2 = new TimelineMax();

    tl.set(circle, {
        x: 15,
        y: 15,
        scale: 0
      })
      .set(slideIn, {
        left: -350,
        opacity: 1
      }, 0)
      .set(block, {
        left: 270,
        opacity: 0
      }, 0)
      .set($prevButton, {
        zIndex: 1
      }, 0)
      .to(circle, 0.5, {
        scale: 1,
        transformOrigin: "50%, 50%",
        opacity: 1
      }, 0)
      .to(circle, 0.3, {
        opacity: 0
      })
      .to(line, 0.3, {
        scale: 0,
        transformOrigin: "50%, 50%"
      }, 0)
      .set(circle, {
        scale: 0,
        opacity: 0
      });

    function tlComplete() {
      tl2.to(slideIn, 0.3, {
          left: 0
        })
        .to(block, 0.3, {
          left: 350,
          opacity: 1
        }, 0);
    };

    function getLineback() {
      TweenMax.to(line, 0.3, {
        scale: 1,
        opacity: 1,
        delay: 0.5
      });
    };

    closeBlock.click(function() {
      tl2.reverse();
    })

    closeBlock.click(getLineback);

    $nextButton.click(function() {
      tl2.reverse();
    });

    $nextButton.click(getLineback);

  });

  slideNext.click(function() {
    clickCount++;
    clickCountImg++;

    var clickCountImgPrev = clickCountImg - 2;
    var firstImage = $('.slideshow__container li img:eq(0)'),
      imagePrev = $('.slideshow__container li img:eq(' + clickCountImgPrev + ')'),
      image = $('.slideshow__container li img:eq(' + clickCountImg + ')');

    if (clickCount > 3) {
      clickCount = 0;
    }
    if (clickCountImg > 3) {
      clickCountImg = 0;
      firstImage.clone().appendTo(slideNext);
    }

    TweenMax.to($slider, 0.5, {
      x: -clickCount * imgWidth
    })

    slideNext.children("img").remove();
    slideBack.children("img").remove();
    image.clone().appendTo(slideNext);
    imagePrev.clone().appendTo(slideBack);
    console.log(image);

    if (clickCountImg == 0) {
      firstImage.clone().appendTo(slideNext);
    }

  });

  slideBack.click(function() {
    clickCount--;
    clickCountImg--;

    var clickCountImgPrev = clickCountImg - 2,
      firstImage = $('.slideshow__container li img:eq(0)'),
      imagePrev = $('.slideshow__container li img:eq(' + clickCountImgPrev + ')'),
      image = $('.slideshow__container li img:eq(' + clickCountImg + ')');

    if (clickCount < 0) {
      clickCount = 3;
    }

    if (clickCountImg < 0) {
      clickCountImg = 3;
    }

    TweenMax.to($slider, 0.5, {
      x: -clickCount * imgWidth
    });

    slideNext.children("img").remove();
    slideBack.children("img").remove();

    imagePrev.clone().appendTo(slideBack);
    image.clone().appendTo(slideNext);

  });
});
</script>

</section>
<!--//header-banner-section-end-here -->
<!--about-section-starts-here -->
<section class="about" id="about" style="background:white;">
	<div class="container">
		<div class="w3ls-about-grids">
			<div class="col-md-4 col-sm-6 about-top-grid w3ls-ma">
				<img src="images/abt1.jpg" class="img-responsive" alt="imges"/>
				<div class="layer">
				</div>
			</div>
			<div class="col-md-4 col-sm-6 about-top-text">
				<h3>关于我们</h3>
				<p>绿色金融指金融部门把环境保护作为一项基本政策，在投融资决策中要考虑潜在的环境影响，
				把与环境条件相关的潜在的回报、风险和成本都要融合进银行的日常业务中，
				在金融经营活动中注重对生态环境的保护以及环境污染的治理，通过对社会经济资源的引导，促进社会的可持续发展。 </p>
				<div class="layer">
				</div>
			</div>
			<div class="col-md-4 col-sm-12 about-top-grid w3ls-ma">
				<img src="images/abt2.jpg" class="img-responsive" alt="imges"/>
				<div class="layer">
				</div>
			</div>
			<div class="clearfix"></div>
			<div class="col-md-6 col-sm-6 abt-btm-grid w3ls-ma">
				<img src="images/abt3.jpg" class="img-responsive" alt="images" width="1185" height="827"/>
				<div class="layer">
				</div>
			</div>
			<div class="col-md-6 col-sm-6 abt-btm-grid w3ls-ma">
				<img src="images/abt4.jpg" class="img-responsive" alt="images" width="1185" height="807"/>
				<div class="layer">
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</section>
<!--//about-section-end-here -->
<!--services-section-starts-here -->
<section class="services jarallax" id="services" style="background:black">
	<div class="container" style="background:black">
		<h3>联系我们</h3>
		<div class="service-grids">
			<div class="col-md-6 col-sm-6 wthree-left-grid">
				<div class="col-sm-8 col-xs-8 w3l-lt-text">
					<p>电话联系：0000-888888-666666
					</p>
					<div class="line-lt"></div>
				</div>
				<div class="col-sm-4 col-xs-4 service-icon text-center">
					<i class="fa fa-book" aria-hidden="true"></i>
				</div>
				<div class="clearfix"></div>
				<div class="col-sm-8 col-xs-8 w3l-lt-text">
					<p>邮箱联系：99008822@163.com
					</p>
					<div class="line-lt"></div>
				</div>
				<div class="col-sm-4 col-xs-4 service-icon text-center">
					<i class="fa fa-globe" aria-hidden="true"></i>
				</div>
				<div class="clearfix"></div>
				
				
			</div>
			<div class="col-md-6 col-sm-6 wthree-right-grid">
				<div class="col-sm-4 col-xs-4 service-icon text-center">
					<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
				</div>
				<div class="col-sm-8 col-xs-8 w3l-text">
					<p>写信联系：地址-xx省-xx市-xx公司 
					</p>
					<div class="line-rt"></div>
				</div>				
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</section>


<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
<!-- start-smoth-scrolling -->
	<!-- Slide-To-Top JavaScript (No-Need-To-Change) -->
		<script type="text/javascript">
			$(document).ready(function() {
				var defaults = {
					containerID: 'toTop', // fading element id
					containerHoverID: 'toTopHover', // fading element hover id
					scrollSpeed: 100,
					easingType: 'linear'
				};
			});
		</script>
		<a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 0;"> </span></a>
		<!-- //Slide-To-Top JavaScript -->
<!-- jarallax scrolling -->
	<script src="js/jarallax.js"></script>
	<script src="js/SmoothScroll.min.js"></script>
	<script type="text/javascript">
		/* init Jarallax */
		$('.jarallax').jarallax({
			speed: 0.5,
			imgWidth: 1366,
			imgHeight: 768
		})
	</script>
<!-- //jarallax scrolling -->
	<!-- smooth scrolling -->
	<script type="text/javascript">
		$(document).ready(function() {
		/*
			var defaults = {
			containerID: 'toTop', // fading element id
			containerHoverID: 'toTopHover', // fading element hover id
			scrollSpeed: 1200,
			easingType: 'linear' 
			};
		*/								
		$().UItoTop({ easingType: 'easeOutQuart' });
		});
	</script>
<!-- //smooth scrolling -->

</body>
</html>