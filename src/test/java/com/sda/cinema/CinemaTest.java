package com.sda.cinema;

import com.sda.cinema.model.*;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class CinemaTest {

   @Test
    public void userCanReserveMovieAndReciveNotificationWithTicket(){
        //given
        CinemaBookingService cinemaBookingService = Mockito.mock(CinemaBookingService.class);
        Mockito.when(cinemaBookingService.bookSeating(Mockito.any(), Mockito.anyInt()))
                .then(e -> new CinemaBookingStatus(true, null));
        CinemaNotifier cinemaNotifier = Mockito.mock(CinemaNotifier.class);
       Mockito.when(cinemaNotifier.notify(Mockito.any(), Mockito.any(), Mockito.any()))
               .then(e -> new CinemaNotifierResponse(true, null));

        Cinema cinema = new Cinema(cinemaBookingService, cinemaNotifier);

        //when
        CinemaBookingResponse response = cinema.bookMovie(null, 15, null, null);

        //then
        Assert.assertEquals("Miejsce zarezerwowane. Za chwilę dostaniesz swój bilet", response.getMessage());
        Assert.assertTrue(response.isStatus());
        Mockito.verify(cinemaNotifier, Mockito.times(1)).notify(Mockito.any(), Mockito.any(), Mockito.any());
    }

    @Test
    public void userCannotReserveMovieBecauseSelectedSeatingIsInvalid(){
        //given
        CinemaBookingService cinemaBookingService = Mockito.mock(CinemaBookingService.class);
        Mockito.when(cinemaBookingService.bookSeating(Mockito.any(), Mockito.anyInt()))
                .then(e -> new CinemaBookingStatus(false, CinemaBookingStatusCode.WRONG_SEATING_ID));
        CinemaNotifier cinemaNotifier = Mockito.mock(CinemaNotifier.class);

        Mockito.when(cinemaNotifier.notify(Mockito.any(), Mockito.any(), Mockito.any()))
                .then(e -> new CinemaNotifierResponse(true, null));

        Cinema cinema = new Cinema(cinemaBookingService, cinemaNotifier);

        //when
        CinemaBookingResponse response = cinema.bookMovie(null, 15, null, null);

        //then
        Assert.assertEquals("Wybrano niepoprawny numer miejsca", response.getMessage());
        Assert.assertFalse(response.isStatus());
        Mockito.verify(cinemaNotifier, Mockito.never()).notify(Mockito.any(), Mockito.any(), Mockito.any());
    }
    @Test
    public void userCannotReserveMovieBecauseSeatingIsAlreadyBlocked(){
       // given
        CinemaBookingService cinemaBookingService = Mockito.mock(CinemaBookingService.class);
        Mockito.when(cinemaBookingService.bookSeating(Mockito.any(), Mockito.anyInt()))
                .then(e -> new CinemaBookingStatus(false, CinemaBookingStatusCode.SEATING_ALREADY_BOOKED));
        CinemaNotifier cinemaNotifier = Mockito.mock(CinemaNotifier.class);

        Mockito.when(cinemaNotifier.notify(Mockito.any(), Mockito.any(), Mockito.any()))
                .then(e -> new CinemaNotifierResponse(true, null));

        Cinema cinema = new Cinema((cinemaBookingService), cinemaNotifier);

        //when
        CinemaBookingResponse response = cinema.bookMovie(null, 15, null, null);

        //then
        Assert.assertEquals("To miejsce nie jest przeznaczone dla takiej osoby jak ty", response.getMessage());
        Assert.assertFalse(response.isStatus());
        Mockito.verify(cinemaNotifier, Mockito.never()).notify(Mockito.any(), Mockito.any(), Mockito.any());
    }

    @Test
    public void shouldReturnServerErrorMessageWhenThereIsServerErrorInNotifier(){
       //given
        CinemaBookingService bookingService = Mockito.mock(CinemaBookingService.class);
        Mockito.when(bookingService.bookSeating(Mockito.any(), Mockito.anyInt()))
                .then(e -> new CinemaBookingStatus(true, null));

        CinemaNotifier cinemaNotifier = Mockito.mock(CinemaNotifier.class);

        Mockito.when(cinemaNotifier.notify(Mockito.any(), Mockito.any(), Mockito.any()))
                .then(e -> new CinemaNotifierResponse(false, CinemaNotifierResponseStatus.SERVER_ERROR));

        Cinema cinema = new Cinema(bookingService, cinemaNotifier);


        //when
        CinemaBookingResponse cinemaBookingResponse = cinema.bookMovie(null, 0, null, null);

        //then
        Assert.assertFalse(cinemaBookingResponse.isStatus());
        Assert.assertEquals("Ops. Twoj bilet zostal zarezerwowany, ale nie mogliśmy wyslac Ci biletu", cinemaBookingResponse.getMessage());

    }
    @Test
    public void shouldReturnChannelNotSpecyfiedMessageWhenThereWasNoChannelSpecyfied(){
        //given
        CinemaBookingService bookingService = Mockito.mock(CinemaBookingService.class);
        Mockito.when(bookingService.bookSeating(Mockito.any(), Mockito.anyInt()))
                .then(e -> new CinemaBookingStatus(true, null));

        CinemaNotifier cinemaNotifier = Mockito.mock(CinemaNotifier.class);

        Mockito.when(cinemaNotifier.notify(Mockito.any(), Mockito.any(), Mockito.anyString()))
                .then(e -> new CinemaNotifierResponse(false, CinemaNotifierResponseStatus.CHANNEL_NOT_SPECIFIED));

        Cinema cinema = new Cinema(bookingService, cinemaNotifier);


        //when
        CinemaBookingResponse cinemaBookingResponse = cinema.bookMovie(null, 0, null, null);

        //then
        Assert.assertFalse(cinemaBookingResponse.isStatus());
        Assert.assertEquals("Nie moglismy wyslac biletu, poniewaz nie wskazales danych adresowych", cinemaBookingResponse.getMessage());

    }

}

