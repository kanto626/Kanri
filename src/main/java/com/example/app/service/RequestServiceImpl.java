package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.Request;
import com.example.app.mapper.RequestMapper;

import lombok.RequiredArgsConstructor;
@Service
@Transactional
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {

    private final RequestMapper requestMapper;
    @Override
    public void create(Request request) {
        requestMapper.insert(request);
    }

    @Override
    public List<Request> getAll() {
        return requestMapper.selectAll();
    }

    @Override
    public List<Request> getByTeamId(String teamId) {
        return requestMapper.selectByTeamId(teamId);
    }

    @Override
    public Request getById(int id) {
        return requestMapper.selectById(id);
    }

    @Override
    public void updateStatus(Request request) {
        requestMapper.updateStatus(request);
    }

	@Override
	public void deleteRequestById(int id) {
		requestMapper.deleteRequestById(id);
	}
}