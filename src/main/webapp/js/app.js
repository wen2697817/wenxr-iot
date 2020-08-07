// uehtml.com
(function(s) {
	s(function() {
				var lock = true;
				function n() {
					lock && new (function() {
						lock = false;
						var l = s('#slider li:last').clone().prependTo('#slider ul');
						TweenLite.to(s('#slider li:last'), 1, {
									'width' : 0,
									'left' : -50,
									ease : Cubic.easeInOut,
									onComplete : function() {
										s('#slider li:last').remove();
										var id = s("#slider li:last").attr("id");
										s("#lbt a").css("background", "");
										s("#lbt #a" + id).css("background", "#361240");
										lock = true;
									}
								});
					});
				}
				function p() {
					lock && new (function() {
						lock = false;
						var l = s('#slider li:last').clone().appendTo('#slider ul'), f = s('#slider li:first').clone();
						s('#slider li:last').before(f);
						s('#slider li:first').remove();
						s('#slider li:last,#slider li:last img').css({
									'right' : 0,
									'left' : 'auto'
								});
						f.css({
									'left' : 'auto',
									'right' : 300
								});
						TweenLite.to(f, 1, {
									'right' : 0,
									ease : Cubic.easeInOut
								});
						TweenLite.to(s('#slider li:last'), 1, {
									'width' : 0,
									'right' : -50,
									ease : Cubic.easeInOut,
									onComplete : function() {
										s('#slider li:last').remove();
										var id = s("#slider li:last").attr("id");
										s("#lbt a").css("background", "");
										s("#lbt #a" + id).css("background", "#361240");
										lock = true;
									}
								});
					});
				}
				s('.ct-next').click(n);
				s('.ct-prev').click(p);

				function interval() {
					var a = window.setInterval(function() {
								n();
							}, 4000);
					return a;
				}
				function cur(id) {
					lock && new (function() {
						lock = false;
						var lastLi = s("#slider li:last");
						if (id == lastLi.attr("id")) {
							lock = true;
							return;
						}
						var curLi = s("#slider #" + id);
						lastLi.clone().prependTo('#slider ul');
						while (lastLi.prev().attr("id") != curLi.attr("id")) {
							s("#slider li:first").before(lastLi.prev());
						}
						TweenLite.to(s('#slider li:last'), 1, {
									'width' : 0,
									'left' : -50,
									ease : Cubic.easeInOut,
									onComplete : function() {
										s('#slider li:last').remove();
										var id = s("#slider li:last").attr("id");
										s("#lbt a").css("background", "");
										s("#lbt #a" + id).css("background", "#361240");
										lock = true;
									}
								});
					});
				}
				var it = interval();
				s("#lbt a").mouseover(function() {
							window.clearInterval(it);
							cur(s(this).attr("id").substring(1));
						});
				s("#lbt a").mouseout(function() {
							it = interval();
						});
			});
})($);