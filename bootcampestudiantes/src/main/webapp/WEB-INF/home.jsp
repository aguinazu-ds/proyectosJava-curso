<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Document</title>
</head>
<body>
    <div class="container vh-100 overflow-hidden">
        <div class="">
            <div class="col-12 p-3">
            
                <form:form method="POST" action="/" modelAttribute="filtroRegionCurso">
                <form:errors />
                <div class="row">
                    <div class="col-sm-6 my-auto">
                        <div class="row">
                            <div class="col-md-3 my-sm-auto">
                                <h5>Region:</h5>
                            </div>
                            <div class="col-md-9 col-sm-auto">
                                <form:select path="codigo_region" class="form-select">
                                    <c:forEach items="${regiones}" var="region">
                                        <form:option value="${region.id}">${region.nombre}</form:option>
                                    </c:forEach>
                                </form:select>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4 my-sm-auto">
                        <div class="row">
                            <div class="col-md-3 my-sm-auto">
                                <h5>Curso:</h5>
                            </div>
                            <div class="col-md-9 my-sm-auto">
                                <form:select path="codigo_curso" class="form-select">
                                    <c:forEach items="${cursos}" var="curso">
                                        <form:option value="${curso.codigo_curso}">${curso.codigo_curso}</form:option>
                                    </c:forEach>
                                </form:select>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-2 my-auto">
                        <input type="submit" value="Filtrar" class="btn btn-primary"/>
                    </div>
    
                </div>
                </form:form>
            </div>
            <div class="col-12 p-3 table-responsive">
                <table class="table table-responsive table-sm table-bordered">
                    <thead class="text-center">
                        <tr>
                            <th>Rut</th>
                            <th>Nombre</th>
                            <th>Apellido Paterno</th>
                            <th>Apellido Materno</th>
                            <th>Codigo Curso</th>
                            <th>Descripcion Curso</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${estudiantesFiltrados}" var="estudiante">
                            <tr>
                                <td>${estudiante.rut}</td>
                                <td>${estudiante.nombre}</td>
                                <td>${estudiante.apellido_pat}</td>
                                <td>${estudiante.apellido_mat}</td>
                                <td>${codigo_curso}</td>
                                <td>${descripcion_curso}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>     
        </div>

    </div>
</body>
</html>