"user strict";

(function($) {
	var request = $.ajax({'url' : '/posts.json'});
	request.done(function (posts) {
		var html = '';
		posts.forEach(function (post) {
			html += '<div>';
			html += '<h1>' + post.title + '</h1>';
			html += '<p>' + post.content + '</p>';
			html += '<p>' + post.owner.username + '</p>';
			html += '</div>';
		});
		$("#posts").html(html);
	});
})(jQuery);