package br.com.project.application.usecase;

public interface UseCase<Request, Response> {
    Response execute(Request request);
}
