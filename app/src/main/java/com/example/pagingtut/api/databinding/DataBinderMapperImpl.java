package com.example.pagingtut.api.databinding;

import androidx.databinding.MergedDataBinderMapper;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new com.example.pagingtut.DataBinderMapperImpl());
  }
}
