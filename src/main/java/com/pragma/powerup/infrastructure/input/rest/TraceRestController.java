package com.pragma.powerup.infrastructure.input.rest;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.pragma.powerup.application.dto.request.TraceRequest;
import com.pragma.powerup.application.dto.response.TraceResponse;
import com.pragma.powerup.application.handler.ITraceHandler;
import com.pragma.powerup.infrastructure.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/v1/trace")
@RequiredArgsConstructor
public class TraceRestController {
    private final ITraceHandler traceHandler;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("")
    @PreAuthorize("permitAll()")
    public ResponseEntity<Void> saveTrace(@RequestBody TraceRequest traceRequest) {
        traceHandler.saveTrace(traceRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{idOrder}")
    @PreAuthorize("hasRole('Cliente')")
    public ResponseEntity<List<TraceResponse>> getTracesByIdClientAndIdOrder(HttpServletRequest request, @PathVariable Long idOrder) {
        Long idUserRequest = extractIdUserRequest(request.getHeader(HttpHeaders.AUTHORIZATION));
        return ResponseEntity.ok(traceHandler.getTracesByIdClientAndIdOrder(idUserRequest, idOrder));
    }

    private Long extractIdUserRequest(String jwtToken) {
        Long idUserResquest = 0L;

        if (jwtToken != null) {
            jwtToken = jwtToken.substring(7);
            DecodedJWT decodedJWT = jwtUtils.validateToken(jwtToken);
            idUserResquest = Long.parseLong(jwtUtils.getSpecificClaim(decodedJWT, "ui").toString());
        }

        return idUserResquest;
    }
}
