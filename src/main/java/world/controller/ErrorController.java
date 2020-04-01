package world.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import world.exceptions.CityNotFoundException;
import world.exceptions.CountryNotFoundException;
import world.model.ErrorInfo;

@RestControllerAdvice
public class ErrorController {
    private static final Logger logger = LoggerFactory.getLogger(ErrorController.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorInfo processException(Exception e) {
        logger.error("Unexpected error", e);
        return new ErrorInfo(e.getMessage());
    }

    @ExceptionHandler({CityNotFoundException.class, CountryNotFoundException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorInfo processException(CityNotFoundException e) {
        logger.error("Unexpected error", e);
        return new ErrorInfo(e.getMessage());
    }
}
