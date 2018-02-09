package com.advanz101.rest;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.advanz101.error.exception.ResourceNotFoundException;
import com.advanz101.response.Metadata;
import com.advanz101.response.ResponseApiDTO;
import com.advanz101.service.SearchPocService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author sharm
 *
 */
@RestController
@Api(value = "Search POC API")
@RequestMapping(value = "/search", produces = { MediaType.APPLICATION_JSON_VALUE })
public class SearchRest {

	private static String version = "1.0";

	private static final Logger LOGGER = LoggerFactory.getLogger(SearchRest.class);

	@Autowired
	private SearchPocService searchPocService;

	/**
	 * 
	 * @param message
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("rawtypes")
	@ApiOperation(value = "Get Categories")
	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public ResponseEntity<ResponseApiDTO> getCategories() throws IOException {
		ResponseEntity<ResponseApiDTO> response = getResponseEntity(searchPocService.getCategories());
		return response;
	}

	/**
	 * 
	 * @param message
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("rawtypes")
	@ApiOperation(value = "Get Categories")
	@RequestMapping(value = "/letters", method = RequestMethod.GET)
	public ResponseEntity<ResponseApiDTO> getLetters() throws IOException {
		ResponseEntity<ResponseApiDTO> response = getResponseEntity(searchPocService.getAvailableLetters());
		return response;
	}

	/**
	 * 
	 * @param message
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("rawtypes")
	@ApiOperation(value = "Get Categories")
	@RequestMapping(value = "/brands", method = RequestMethod.GET)
	public ResponseEntity<ResponseApiDTO> getBrands(@RequestParam(required = false) String brand,
			@RequestParam(required = false) String category) throws IOException {
		LOGGER.debug("Request input - Brand = " + brand + " , Category = " + category);
		ResponseEntity<ResponseApiDTO> response = getResponseEntity(searchPocService.getBrands(brand, category));
		return response;
	}

	/**
	 * 
	 * @param result
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	private ResponseEntity<ResponseApiDTO> getResponseEntity(List result) {
		return createResponseEntity(result, null);
	}

	/**
	 * 
	 * @param result
	 * @param message
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private ResponseEntity<ResponseApiDTO> createResponseEntity(List result, String message) {
		Metadata metadata;
		org.springframework.http.HttpStatus status = null;
		ResponseApiDTO response = null;
		if (result == null || result.size() == 0) {
			metadata = new Metadata(version, 404, null);
			metadata.setMessage(message);
			throw new ResourceNotFoundException(null, metadata, "Resource not found");
		} else {
			metadata = new Metadata(version, HttpStatus.OK.value(), result.size());
			metadata.setMessage(message);
			response = new ResponseApiDTO(metadata, result, null);
			status = HttpStatus.OK;
		}

		return new ResponseEntity<ResponseApiDTO>(response, status);
	}

}
