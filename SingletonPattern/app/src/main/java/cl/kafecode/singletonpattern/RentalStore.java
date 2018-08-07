package cl.kafecode.singletonpattern;

import java.util.ArrayList;

//Singleton
public class RentalStore {

    //instanciar un objeto de mi mismo
    //va a ser el unico objeto instanciado de la clase RentalStore
    private static RentalStore sharedInstance = new RentalStore();

    //Gestor de mis peliculas
    private ArrayList<Movie> mMovies;

    //Cualquiera que quiera usar mi singleton necesitara llamar al metodo GetInstance
    public static RentalStore getInstance(){
        return sharedInstance;
    }

    //para no crear mas instancias, su unico constructor es privado
    private RentalStore(){

        //el constructor inicializa el array de peliculas vacio
        mMovies = new ArrayList<Movie>();
    }

    public ArrayList<Movie> getMovies(){
        return mMovies;
    }

    public Movie getMovieAt(int index){
        return mMovies.get(index);
    }

    public void addMovie(Movie m){
        mMovies.add(m);
    }

    public void removeMovie(Movie m){
        mMovies.remove(m);
    }




}
