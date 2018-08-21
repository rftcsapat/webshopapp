<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<div class="container">
        <hr>
        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Your Website 2014</p>
                </div>
            </div>
        </footer>

    </div>
    
    <c:if test="${not empty user}">
	    <a class="basket-button" href="${baseUrl}/basket">
	    	Kosár megtekintése
	    </a>
    </c:if>
    
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="${baseUrl}/public/lib/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
	<script src="${baseUrl}/public/lib/ion.rangeSlider-2.1.4/js/ion-rangeSlider/ion.rangeSlider.min.js"></script>
	<script>
		$("#ar-valaszto").ionRangeSlider({
		    min: 0,
		    max: 10000,
		    from: 1000,
		    to: 9000,
		    type: 'double',
		    step: 100,
		    postfix: "Ft",
		    grid: true,
		    grid_num: 10
		});
	</script>
</body>
</html>
