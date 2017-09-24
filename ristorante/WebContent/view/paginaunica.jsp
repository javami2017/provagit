<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<c:if test="${empty sessionPhase}">
	<c:set var="sessionPhase" value="1" scope="session" />
</c:if>

<c:if test="${sessionPhase eq 1}">
	<title>Inserimento Clienti</title>
	<link rel="stylesheet" href="clienteStile.css">
	<script>
		function checkAndSubmit() {

			var textbox = document.form2.cliente_1.value;
			var len = textbox.length;

			if (len == 0) {
				alert("Enter Your Name Please!");
				return false;
			}
			// or you may use if(myName=="") for a condition if u prefer to use text
			form2.submit();
		}
	</script>
</c:if>

<c:if test="${sessionPhase eq 2}">
	<title>Ordini</title>
	<link rel="stylesheet" href="orderStyle.css" />
	<link rel="stylesheet" href="buttonStyle.css" />
</c:if>

</head>
<body>
	<c:if test="${sessionPhase eq 1}">
		<c:set var="phase" value="1" scope="session" />
		<h1>IMPOSTA TAVOLO</h1>
		<form method="post" action="GreMaRiMaServlet" name="form">
			<div class="tavoli">
				Tavolo n. <select name="tavolo">
					<option selected value="${tavoloSelezionato}">${tavoloSelezionato}</option>
					<c:forEach var="i" begin="1" end="4">
						<option value="${i}">${i} </option>
						<p>
					</c:forEach>
				</select>
			</div>
			<table class="clienti">
				<tr>
					<th>Numero clienti</th>

					<td><select name="numero" onchange="this.form.submit();">
							<option selected value="${numeroClienti}">${numeroClienti}</option>
							<c:forEach var="i" begin="1" end="6">
								<option value="${i}">${i}</option>
							</c:forEach>
					</select></td>
				</tr>
			</table>
			<input type="hidden" name="requestPhase" value="1" />
		</form>
		<form method="post" action="GreMaRiMaServlet">
			<div>
				<c:forEach var="nc" begin="1" end="${numeroClienti}">
		
            Nome cliente <c:out value="${nc}" />:
            <input type="text" name="cliente_<c:out value="${nc}" />" />
					<br />

				</c:forEach>
			</div>
			<input type="hidden" name="requestPhase" value="2" name="form2" />
			<button type="submit" name="proceedToOrder" value="true">Invia</button>
		</form>
	</c:if>
	<c:if test="${sessionPhase eq 2}">
		<div class="titolo">
			<h1>ORDINI</h1>
		</div>
		<form method="post" action="GreMaRiMaServlet">
			<input type="hidden" name="phase" value="3" />
			<div class="client">
				Cliente: <select name="clientId">
					<c:forEach items="${clienti}" var="cliente">
						<option value="${cliente.value.id}">${cliente.value.name}</option>/>
					</c:forEach>
				</select>
			</div>
			<div class="tavolo">Tavolo n. ${tavoloSelezionato}</div>
			<br />
			<div class="container">
				<p>PRIMI</p>
				<div class="divTable">
					<div class="divTableBody">
						<c:forEach items="${menu}" var="dish">
							<c:if test="${dish.course == 'Primo' }">
								<div class="divTableRow">
									<div class="divTableCell" id="quantita">
										<tg-list> <tg-list-item> <input
											class="tgl tgl-flip" id="cb_${dish.id}" type="checkbox"
											name="cb_${dish.id}" value="${dish.id}" /> <label
											class="tgl-btn" data-tg-off="Nope" data-tg-on="Yeah"
											for="cb_${dish.id}"></label> </tg-list-item> </tg-list>
									</div>
									<div class="divTableCell" id="pietanza">
										<span class="entry"><c:out value="${dish.name}" /></span>
									</div>
									<div class="divTableCell" id="prezzo">
										<c:out value="${dish.price}" />
									</div>
								</div>
							</c:if>
						</c:forEach>
					</div>
				</div>
				<p>SECONDI</p>
				<div class="divTable">
					<div class="divTableBody">
						<c:forEach items="${menu}" var="dish">
							<c:if test="${dish.course == 'Secondo' }">
								<div class="divTableRow">
									<div class="divTableCell">
										<tg-list> <tg-list-item> <input
											class="tgl tgl-flip" id="cb_${dish.id}" type="checkbox"
											name="cb_${dish.id}" value="${dish.id}" /> <label
											class="tgl-btn" data-tg-off="Nope" data-tg-on="Yeah"
											for="cb_${dish.id}"></label> </tg-list-item> </tg-list>
									</div>
									<div class="divTableCell" id="pietanza">
										<span class="entry"><c:out value="${dish.name}" /></span>
									</div>
									<div class="divTableCell" id="prezzo">
										<c:out value="${dish.price}" />
									</div>
								</div>
							</c:if>
						</c:forEach>
					</div>
				</div>
				<p>CONTORNI</p>
				<div class="divTable">
					<div class="divTableBody">
						<c:forEach items="${menu}" var="dish">
							<c:if test="${dish.course == 'Contorno' }">
								<div class="divTableRow">
									<div class="divTableCell">
										<tg-list> <tg-list-item> <input
											class="tgl tgl-flip" id="cb_${dish.id}" type="checkbox"
											name="cb_${dish.id}" value="${dish.id}" /> <label
											class="tgl-btn" data-tg-off="Nope" data-tg-on="Yeah"
											for="cb_${dish.id}"></label> </tg-list-item> </tg-list>
									</div>
									<div class="divTableCell" id="pietanza">
										<span class="entry"><c:out value="${dish.name}" /></span>
									</div>
									<div class="divTableCell" id="prezzo">
										<c:out value="${dish.price}" />
									</div>
								</div>
							</c:if>
						</c:forEach>
					</div>
				</div>
				<p>DOLCI</p>
				<div class="divTable">
					<div class="divTableBody">
						<c:forEach items="${menu}" var="dish">
							<c:if test="${dish.course == 'Dolce' }">
								<div class="divTableRow">
									<div class="divTableCell">
										<tg-list> <tg-list-item> <input
											class="tgl tgl-flip" id="cb_${dish.id}" type="checkbox"
											name="cb_${dish.id}" value="${dish.id}" /> <label
											class="tgl-btn" data-tg-off="Nope" data-tg-on="Yeah"
											for="cb_${dish.id}"></label> </tg-list-item> </tg-list>
									</div>
									<div class="divTableCell" id="pietanza">
										<span class="entry"><c:out value="${dish.name}" /></span>
									</div>
									<div class="divTableCell" id="prezzo">
										<c:out value="${dish.price}" />
									</div>
								</div>
							</c:if>
						</c:forEach>
					</div>
				</div>
				<div class="orderButton">
					<button type="submit" name="phase" value="3">Invia</button>
				</div>
			</div>
		</form>
	</c:if>
	<c:if test="${sessionPhase eq 3}">fine della nostra parte, cancella i cookie</c:if>
</body>
</html>